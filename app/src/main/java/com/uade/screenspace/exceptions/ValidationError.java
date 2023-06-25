package com.uade.screenspace.exceptions;

public class ValidationError extends RuntimeException{
    public ValidationError(String message) {
        super(message);
    }
}
