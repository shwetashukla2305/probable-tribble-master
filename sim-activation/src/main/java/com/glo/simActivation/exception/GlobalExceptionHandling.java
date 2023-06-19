package com.glo.simActivation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(InvalidSimidException.class)
    public ResponseEntity<String> invalidSimIdException(InvalidSimidException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidSimDetailsException.class)
    public ResponseEntity<String> invalidSimDetailsException(InvalidSimDetailsException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SIMAlreadyActiveException.class)
    public ResponseEntity<String> simAlreadyActiveException(SIMAlreadyActiveException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }
}
