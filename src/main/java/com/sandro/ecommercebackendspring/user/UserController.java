package com.sandro.ecommercebackendspring.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
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
    public String login(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping("/users")
    public Object getUsers() {
        return userService.getUsers();
    }

}
