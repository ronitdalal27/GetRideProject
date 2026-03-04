package com.example.GetRide.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handles @Valid validation errors (name, age, email)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String field = error.getField();
            String message = error.getDefaultMessage();
            errors.put(field, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


    // Handles invalid ENUM values inside JSON body (e.g., gender = "animal")
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleEnumJsonError(HttpMessageNotReadableException ex) {

        Map<String, String> error = new HashMap<>();

        // Check if the exception is related to Gender enum
        if (ex.getMessage() != null && ex.getMessage().contains("Gender")) {
            error.put("gender", "Gender must be MALE, FEMALE or OTHER");
        } else {
            error.put("error", "Malformed JSON request");
        }

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
