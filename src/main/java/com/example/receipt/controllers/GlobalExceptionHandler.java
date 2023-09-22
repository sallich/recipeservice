package com.example.receipt.controllers;

import com.example.receipt.exceptions.RecipeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RecipeNotFoundException.class)
    public ResponseEntity<?> recipeException(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
