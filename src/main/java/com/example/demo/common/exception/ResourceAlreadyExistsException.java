package com.example.demo.common.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    private static final String DESCRIPTION = "Resource cant be repeated";
    public ResourceAlreadyExistsException(String message) {
        super(DESCRIPTION + message);
    }
}
