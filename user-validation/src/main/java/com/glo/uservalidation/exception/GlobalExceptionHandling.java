package com.glo.uservalidation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(CustomerIdNotFoundException.class)
    public ResponseEntity<String> customerIdNotFoundException(CustomerIdNotFoundException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidBasicDetailException.class)
    public ResponseEntity<String> invalidBasicDetailException(InvalidBasicDetailException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidIdentityDetailException.class)
    public ResponseEntity<String> invalidIdentityDetailException(InvalidIdentityDetailException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPersonalDetailException.class)
    public ResponseEntity<String> invalidPersonalDetailException(InvalidPersonalDetailException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TermsNotAcceptedException.class)
    public ResponseEntity<String> termsNotAcceptedException(TermsNotAcceptedException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SIMAlreadyActiveException.class)
    public ResponseEntity<String> simAlreadyActiveException(SIMAlreadyActiveException exception) {

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }
}
