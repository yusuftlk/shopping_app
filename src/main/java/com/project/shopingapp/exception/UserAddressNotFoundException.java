package com.project.shopingapp.exception;

public class UserAddressNotFoundException extends RuntimeException{
    public UserAddressNotFoundException(String message){
        super(message);
    }
}
