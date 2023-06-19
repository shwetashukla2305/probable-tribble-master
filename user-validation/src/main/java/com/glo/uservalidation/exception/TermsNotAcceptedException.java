package com.glo.uservalidation.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TermsNotAcceptedException extends RuntimeException{

    private String message;
}
