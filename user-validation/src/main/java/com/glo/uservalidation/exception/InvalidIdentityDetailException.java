package com.glo.uservalidation.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InvalidIdentityDetailException extends RuntimeException{

    private String message;
}
