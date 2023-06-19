package com.glo.simActivation.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class InvalidSimidException extends RuntimeException{

    private String message;
}
