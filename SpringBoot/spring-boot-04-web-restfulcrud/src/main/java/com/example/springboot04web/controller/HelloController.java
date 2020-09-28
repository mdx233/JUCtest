package com.example.springboot04web.controller;

import com.example.springboot04web.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello.do")
    public String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World!";
    }


    @RequestMapping("/success.do")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("张三","李四","王五"));
        return "success";
    }

    @RequestMapping("/one")
    public String one(){
        return "one";
    }

//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }
}
