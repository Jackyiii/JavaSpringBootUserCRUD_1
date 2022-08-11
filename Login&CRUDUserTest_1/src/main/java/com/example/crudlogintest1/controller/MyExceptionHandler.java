package com.example.crudlogintest1.controller;

import com.example.crudlogintest1.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e){
        Map<String,Object> map=new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return "forward:/error";
    }
}
