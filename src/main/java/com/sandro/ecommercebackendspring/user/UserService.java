package com.sandro.ecommercebackendspring.user;

import com.sandro.ecommercebackendspring.jwt.JWTService;
import com.sandro.ecommercebackendspring.validator.ObjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

    private final JWTService jwtService;

    private final ObjectValidator objectValidator;

    @Autowired
    public UserService(UserRepository userRepository, JWTService jwtService, ObjectValidator objectValidator) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.objectValidator = objectValidator;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new UserPrincipal(user);
    }

    public Object getUsers() {
        return userRepository.findAll();
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


    public String login(User user) {
        User userFromDb = userRepository.findByEmail(user.getEmail());
        if (bCryptPasswordEncoder.matches(user.getPassword(), userFromDb.getPassword())) {
            return jwtService.createToken(user.getEmail());
        }
        return "Invalid credentials";
    }
}
