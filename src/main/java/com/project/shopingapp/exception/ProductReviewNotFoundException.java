package com.project.shopingapp.exception;

public class ProductReviewNotFoundException extends RuntimeException{
    public ProductReviewNotFoundException(String message){
        super(message);
    }
}
