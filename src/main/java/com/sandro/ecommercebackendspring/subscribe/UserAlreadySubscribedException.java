package com.sandro.ecommercebackendspring.subscribe;

import lombok.Getter;

import java.util.Map;

@Getter
public class UserAlreadySubscribedException extends RuntimeException {
    private final Map<String, String> details;

    public UserAlreadySubscribedException(String message) {
        super(message);
        this.details = Map.of("message", message);
    }
}
