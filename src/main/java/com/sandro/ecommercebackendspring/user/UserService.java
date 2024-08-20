package com.sandro.ecommercebackendspring.user;

import com.sandro.ecommercebackendspring.jwt.JWTService;
import com.sandro.ecommercebackendspring.validator.ObjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

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

    public Object createUser(User user) {

        String validationError = validateUser(user);

        if (validationError != null) {
            return validationError;
        }

        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "User already exists";
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    private String validateUser(User user) {
        var violations = objectValidator.validate(user);
        if (!violations.isEmpty()) {
            return violations.toString();
        }
        return null;
    }


    public String login(User user) {
        User userFromDb = userRepository.findByEmail(user.getEmail());
        if (bCryptPasswordEncoder.matches(user.getPassword(), userFromDb.getPassword())) {
            return jwtService.createToken(user.getEmail());
        }
        return "Invalid credentials";
    }
}
