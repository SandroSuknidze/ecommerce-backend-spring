package com.sandro.ecommercebackendspring.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    @PostMapping("/register")
    public String register() {
        return "Hello register user";
    }



}
