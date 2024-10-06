package com.sandro.ecommercebackendspring.exceptions;

import com.sandro.ecommercebackendspring.subscribe.UserAlreadySubscribedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadySubscribedException.class)
    public ResponseEntity<?> handleUserAlreadySubscribedException(UserAlreadySubscribedException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getDetails());
    }
}
