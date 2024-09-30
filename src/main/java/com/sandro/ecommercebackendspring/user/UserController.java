package com.sandro.ecommercebackendspring.user;

import com.sandro.ecommercebackendspring.user.dto.LoginRequest;
import com.sandro.ecommercebackendspring.user.model.User;
import com.sandro.ecommercebackendspring.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public Object createUser(@RequestBody User user) {
        Map<String, Map<String, List<String>>> errors = userService.createUser(user);
        Object isUserExists = userService.checkUserExists(user);

        if (errors != null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(errors);
        }

        if (isUserExists != null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(isUserExists);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.registerUser(user));
    }

    @PostMapping("/login")
    public Object login(@RequestBody LoginRequest loginRequest) {
        List<String> errors = userService.validateLogin(loginRequest);
        if (!errors.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(errors);
        }

        return userService.login(loginRequest);
    }

    @PostMapping("/forgot-password")
    public Object forgotPassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        return userService.processForgotPassword(email);

    }

    @PostMapping("/validate-password-token")
    public ResponseEntity<?> validatePasswordToken(@RequestBody Map<String, String> request) {
        String token = request.get("token");
        Map<String, String> isValid = userService.isResetPasswordTokenValid(token);

        if (!isValid.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(isValid);
        }

        return ResponseEntity.ok(userService.processResetPasswordTokenValidation(token));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> request) {
        String token = request.get("token");
        String password = request.get("password");

        Map<String, String> isValid = userService.isResetPasswordTokenValid(token);
        if (!isValid.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(isValid);
        }

        return ResponseEntity.ok(userService.processResetPassword(token, password));
    }

    @GetMapping("/validate-token")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String token) {
        // jwt filter handles validity of the token, but it is still here, just in case
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Token not provided"));
        }

        Map<String, Object> validationResponse = userService.validateJwtToken(token);
        if (validationResponse.get("valid").equals(false)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(validationResponse);
        }

        return ResponseEntity.ok(validationResponse);
    }


}
