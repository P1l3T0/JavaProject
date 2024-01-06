package com.JavaProject.JavaProjectBackend.ErrorHandling;

public class CategoryNotFoundException extends RuntimeException{
    private static final long serialVerisionUID = 5;
    public CategoryNotFoundException(String message) {
        super(message);
    }

}
