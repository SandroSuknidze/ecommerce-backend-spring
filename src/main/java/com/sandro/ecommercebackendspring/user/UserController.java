package com.sandro.ecommercebackendspring.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public Object createUser( @RequestBody User user) {
        return userService.createUser(user);
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
