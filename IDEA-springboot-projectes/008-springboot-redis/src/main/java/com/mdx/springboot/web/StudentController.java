package com.mdx.springboot.web;

import com.mdx.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/put")
    public @ResponseBody Object put(String key,String value){
        studentService.put(key,value);
        return "值已成功放入redis";
    }

    @RequestMapping("/get")
    public @ResponseBody String get(){
        String value = studentService.get("cout");
        return value;
    }
}
