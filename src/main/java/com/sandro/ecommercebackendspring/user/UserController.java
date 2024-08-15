package com.sandro.ecommercebackendspring.user;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register() {
        return "Hello register user";
    }

    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        return "Hello test" + request.getSession().getId();
    }

    @GetMapping("/protected-test")
    public String protectedTest() {
        return "Hello protected test";
    }

    @GetMapping("/users")
    public Object getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/users")
    public Object createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping("/log")
    public String logout() {
        return "log";
    }




}
