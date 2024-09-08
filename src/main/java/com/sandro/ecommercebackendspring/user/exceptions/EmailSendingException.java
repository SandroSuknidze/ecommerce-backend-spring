package com.sandro.ecommercebackendspring.user.exceptions;

public class EmailSendingException extends RuntimeException{
    public EmailSendingException(String message, Throwable cause) {
        super(message, cause);
    }
}
