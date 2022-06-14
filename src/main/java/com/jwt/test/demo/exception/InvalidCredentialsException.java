package com.jwt.test.demo.exception;

public class InvalidCredentialsException extends IllegalArgumentException{
    public InvalidCredentialsException(String s) {
        super(s);
    }
}
