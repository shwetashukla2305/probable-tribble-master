package com.glo.uservalidation.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SIMAlreadyActiveException extends RuntimeException {

    private String message;
}
