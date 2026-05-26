package com.uca.pncsegundoparcialveterinaria.exceptions;

import com.uca.pncsegundoparcialveterinaria.domain.dto.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.time.LocalDate;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleProductNotFound(ResourceNotFoundException productNotFound) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .timestamp(LocalDate.now())
                .code(HttpStatus.NOT_FOUND.value())
                .message(productNotFound.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<ApiErrorResponse> HandleProductBusinessRule(BusinessRuleException productBusinessRule){
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .timestamp(LocalDate.now())
                .code(HttpStatus.BAD_REQUEST.value())
                .message(productBusinessRule.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errors = methodArgumentNotValidException.getBindingResult()
                .getFieldErrors().stream().collect(
                        java.util.stream.Collectors.toMap(
                                org.springframework.validation.FieldError::getField,
                                fe -> fe.getDefaultMessage() != null ? fe.getDefaultMessage() : "Invalid value"
                        )
                );

        return new ResponseEntity<>(
                ApiErrorResponse.builder()
                        .timestamp(LocalDate.now())
                        .code(HttpStatus.BAD_REQUEST.value())
                        .message("Validation failed")
                        .errors(errors)
                        .build(), HttpStatus.BAD_REQUEST
        );
    }
}
