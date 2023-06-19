package com.glo.simActivation.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InvalidSimDetailsException extends RuntimeException{

    private String message;
}
