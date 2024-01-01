package com.JavaProject.JavaProjectBackend.ErrorHandling;

public class OwnerNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 4;

    public OwnerNotFoundException(String message) {
        super(message);
    }
}
