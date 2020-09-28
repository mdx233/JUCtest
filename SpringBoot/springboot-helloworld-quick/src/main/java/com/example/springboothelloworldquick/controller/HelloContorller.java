package com.example.springboothelloworldquick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController //作用与@Controller与@ResponseBody一起的作用一致，底层包含了这两个注解
public class HelloContorller {

//    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world quick!";
    }
}
