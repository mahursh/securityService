package com.mftplus.secondsecurityservice.exception;

public class AccessDeniedException extends ExceptionPattern{

    public AccessDeniedException(String message){
        super(message);
        setStatusCode(403);
    }
}
