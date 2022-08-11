package com.example.crudlogintest1.exception;

public class UserNotExistException extends RuntimeException{
    public UserNotExistException(){
        super("User Not Exit");
    }
}
