package com.glo.uservalidation.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InvalidBasicDetailException extends RuntimeException{

    private String message;
}
