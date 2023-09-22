package com.example.receipt.exceptions;

public class RecipeNotFoundException extends RuntimeException {
    public RecipeNotFoundException(String message){
        super(message);
    }
}
