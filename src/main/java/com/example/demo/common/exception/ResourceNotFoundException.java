package com.example.demo.common.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final String DESCRIPTION = "Resource not found";

    public ResourceNotFoundException(String message) {
        super(DESCRIPTION + ". "+ message);
    }
}