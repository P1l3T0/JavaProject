package com.JavaProject.JavaProjectBackend.ErrorHandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    public class PokemonNotFoundExceptionHandler implements ICustomExceptionHandler<PokemonNotFoundException> {
        @ExceptionHandler(PokemonNotFoundException.class)
        public ResponseEntity<ErrorObject> handlePokemonNotFoundException(PokemonNotFoundException ex, WebRequest request) {
            return handleCustomException(ex, request);
        }
    }

    public class ReviewNotFoundExceptionHandler implements ICustomExceptionHandler<ReviewNotFoundException> {
        @ExceptionHandler(ReviewNotFoundException.class)
        public ResponseEntity<ErrorObject> handleReviewNotFoundException(ReviewNotFoundException ex, WebRequest request) {
            return handleCustomException(ex, request);
        }
    }

    public class CountryNotFoundExceptionHandler implements ICustomExceptionHandler<CountryNotFoundException> {
        @ExceptionHandler(CountryNotFoundException.class)
        public ResponseEntity<ErrorObject> handleCountryNotFoundException(CountryNotFoundException ex, WebRequest request) {
            return handleCustomException(ex, request);
        }
    }

}
