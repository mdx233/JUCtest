package com.example.springboot04web.exception;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException(){
        super("用户不存在！");

    }
}
