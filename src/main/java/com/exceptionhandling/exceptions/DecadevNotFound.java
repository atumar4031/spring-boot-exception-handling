package com.exceptionhandling.exceptions;

public class DecadevNotFound extends RuntimeException{
    public DecadevNotFound(String message) {
        super(message);
    }

    public DecadevNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
