package com.inventnow.projectx.user.exception;

import com.inventnow.projectx.exception.ConflictException;

public class UserAlreadyRegisteredException extends ConflictException {

    public UserAlreadyRegisteredException(String message){
        super(message);
    }
}
