package com.github.rossetero.exceptions;

public class NotSavedSubEntityException extends RuntimeException{
    public NotSavedSubEntityException(){
        super("This id doesn't exists");
    }
}
