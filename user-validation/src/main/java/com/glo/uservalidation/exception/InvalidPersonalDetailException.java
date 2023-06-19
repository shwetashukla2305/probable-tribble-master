package com.glo.uservalidation.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InvalidPersonalDetailException extends RuntimeException{

    private String message;
}
