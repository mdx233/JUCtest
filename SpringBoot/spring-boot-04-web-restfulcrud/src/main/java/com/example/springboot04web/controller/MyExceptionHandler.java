package com.example.springboot04web.controller;

import com.example.springboot04web.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {


//    //浏览器，客户端返回的都是json数据
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handlerException(Exception e){
//
//        Map<String,Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request){

        Map<String,Object> map = new HashMap<>();
        //传入自己的的错误状态码
        request.setAttribute("javax.servlet.error.status_code    ",500  );
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        //转发到/error（进行自适应处理，浏览器返回错误页面，客户端返回json数据）
        return "forward:/error";
    }
}
