package com.mdx.springboot.web;

import com.mdx.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/count")
    public @ResponseBody String studentCount(){
        Integer studentCount = studentService.queryStudentCount();

        return "总学生人数为："+studentCount;
    }
}
