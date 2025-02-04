package com.fabricate.productservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){

        CustomErrorDetails customErrorDetails = new CustomErrorDetails(
            LocalDateTime.now(),
            exception.getMessage(),
            webRequest.getDescription(false),
            "Product is not found"
        );
        return new ResponseEntity<>(customErrorDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorDetails> handleGlobalException(Exception exception, WebRequest webRequest){

        CustomErrorDetails customErrorDetails = new CustomErrorDetails(
            LocalDateTime.now(),
            exception.getMessage(),
            webRequest.getDescription(false),
            "INTERNAL SERVER ERROR"
        );

        return new ResponseEntity<>(customErrorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
