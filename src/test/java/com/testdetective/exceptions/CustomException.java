package com.testdetective.exceptions;

public class CustomException extends RuntimeException {

    public CustomException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
