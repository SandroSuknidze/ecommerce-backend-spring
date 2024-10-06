package com.sandro.ecommercebackendspring.user.service;

import com.sandro.ecommercebackendspring.jwt.JWTService;
import com.sandro.ecommercebackendspring.user.dto.LoginRequest;
import com.sandro.ecommercebackendspring.user.dto.UserDTO;
import com.sandro.ecommercebackendspring.exceptions.EmailSendingException;
import com.sandro.ecommercebackendspring.user.model.PasswordResetToken;
import com.sandro.ecommercebackendspring.user.model.User;
import com.sandro.ecommercebackendspring.user.model.UserPrincipal;
import com.sandro.ecommercebackendspring.user.repository.PasswordResetTokenRepository;
import com.sandro.ecommercebackendspring.user.repository.UserRepository;
import com.sandro.ecommercebackendspring.validator.ObjectValidator;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
//Generates a constructor for all final fields and fields that are marked with @NonNull.
//Ignores non-final fields unless they are marked with @NonNull.
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

    private final JWTService jwtService;

    private final ObjectValidator objectValidator;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private final PasswordResetTokenRepository passwordResetTokenRepository;

    @Value("${frontend.url}")
    private String frontendUrl;

    private final SendEmailService sendEmailService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new UserPrincipal(user);
    }


    public Map<String, Map<String, List<String>>> createUser(User user) {

        Map<String, Map<String, List<String>>> validationErrors = validateUser(user);

        if (validationErrors != null && !validationErrors.isEmpty()) {
            return validationErrors;
        }

        return null;
    }

    private Map<String, Map<String, List<String>>> validateUser(User user) {
        var violations = objectValidator.validate(user);
        if (!violations.isEmpty()) {
            return violations;
        }
        return null;
    }

    public Object checkUserExists(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return Map.of(
                    "errors", Map.of(
                            "email", List.of("User with this email already exists.")
                    )
            );
        }
        return null;
    }

    public Map<String, String> registerUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return Map.of("access_token", jwtService.createToken(user.getEmail()));
    }

    public List<String> validateLogin(LoginRequest loginRequest) {
        List<String> errors = new java.util.ArrayList<>(List.of());
        try {
            User userFromDb = userRepository.findByEmail(loginRequest.getEmail());

            if (userFromDb == null) {
                errors.add("The provided credentials are incorrect.");
                return errors;
            }

            if (!bCryptPasswordEncoder.matches(loginRequest.getPassword(), userFromDb.getPassword())) {
                errors.add("The provided credentials are incorrect.");
                return errors;
            }
        } catch (Exception e) {
            log.error("Cannot set user authentication: {}", e.getMessage());
            errors.add("The provided credentials are incorrect.");
            return errors;
        }
        return errors;
    }

    public UserDTO toUserDTO(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        return new UserDTO(user.getId(), user.getFirst_name(), user.getLast_name(), user.getEmail());
    }

    public Object login(LoginRequest loginRequest) {
        String accessToken = jwtService.createToken(loginRequest.getEmail());

        return Map.of(
                "access_token", accessToken,
                "user", toUserDTO(loginRequest)
        );
    }


    @Transactional
    public Object processForgotPassword(String email) {
        if (!validateEmail(email)) {
            return Map.of(
                    "message", "Invalid email address."
            );
        }

        User user = userRepository.findByEmail(email);
        if (user == null) {
            return Map.of(
                    "message", "If this email is registered, you will receive a password reset link shortly."
            );
        }

        deleteTokensByUserId(user.getId());

        String token = generateSecureToken();

        PasswordResetToken passwordResetToken = PasswordResetToken.builder()
                .token(token)
                .user(user)
                .expiryDate(calculateExpiryDate())
                .build();

        passwordResetTokenRepository.save(passwordResetToken);
        sendResetLink(email, token);


        return Map.of(
                "message", "If this email is registered, you will receive a password reset link shortly."
        );
    }

    private boolean validateEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.matches();
    }

    private String generateSecureToken() {
        return UUID.randomUUID().toString();
    }

    private Date calculateExpiryDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 1);
        return calendar.getTime();
    }

    public void deleteTokensByUserId(Long userId) {
        passwordResetTokenRepository.deleteByUserId(userId);
    }

    private String generateResetLink(String token) {
        return frontendUrl + "/account/reset-password?token=" + token;
    }

    public void sendResetLink(String email, String token) {
        try {
            sendEmailService.sendEmail(email, "Password Reset Link", generateResetLink(token));
        } catch (MessagingException e) {
            log.error("Failed to send reset link to email: {}", email, e);
            throw new EmailSendingException("Failed to send password reset link.", e);
        }
    }


    public Map<String, String> isResetPasswordTokenValid(String token) {
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);

        if (passwordResetToken == null) {
            return Map.of(
                    "message", "Invalid or expired token"
            );
        }

        Date expiryDate = passwordResetToken.getExpiryDate();
        Date now = new Date();

        if (passwordResetToken.getUser() == null || now.after(expiryDate)) {
            return Map.of(
                    "message", "Invalid or expired token"
            );
        }

        return Map.of();
    }

    public Map<String, String> processResetPasswordTokenValidation(String token) {
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);
        return Map.of(
                "message", "Token is valid",
                "email", passwordResetToken.getUser().getEmail()
        );
    }

    @Transactional
    public Map<String, String> processResetPassword(String token, String password) {
        User user = passwordResetTokenRepository.findByToken(token).getUser();

        user.setPassword(bCryptPasswordEncoder.encode(password));
        deleteTokensByUserId(user.getId());

        return Map.of(
                "message", "Password reset successfully"
        );
    }


    public Map<String, Object> validateJwtToken(String token) {

        String email = jwtService.extractEmail(token);
        if (email == null) {
            return Map.of("message", "Invalid token");
        }

        UserDetails userDetails = loadUserByUsername(email);
        boolean isValid = jwtService.validateToken(token, userDetails);

        if (!isValid) {
            return Map.of(
                    "valid", false,
                    "message", "Invalid token"
            );
        }

        User user = userRepository.findByEmail(email);

        return Map.of(
                "valid", true,
                "user", user
        );
    }
}
