package com.JavaProject.JavaProjectBackend.ErrorHandling;

public class CountryNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 3;
    public CountryNotFoundException(String message) {
        super(message);
    }
}