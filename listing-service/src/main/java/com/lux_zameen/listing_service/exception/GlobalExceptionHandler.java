package com.lux_zameen.listing_service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles validation exceptions thrown by the application.
     *
     * @param ex the MethodArgumentNotValidException containing validation errors
     * @return a ResponseEntity with a map of field names and their respective error messages
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(fieldError -> fieldError.getField(),
                                          fieldError -> fieldError.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);

    }
}
