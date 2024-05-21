package com.mftplus.secondsecurityservice.exception;

public class NoUserFoundException extends ExceptionPattern{
    public NoUserFoundException(String message) {
        super(message);
        setStatusCode(404);
    }
}
