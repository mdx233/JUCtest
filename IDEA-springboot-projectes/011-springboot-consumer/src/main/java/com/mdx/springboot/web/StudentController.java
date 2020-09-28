package com.mdx.springboot.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mdx.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    //获取dubbo暴露的服务，类似于dubbo的配置<dubbo:reference interface="" version=""/>
    @Reference(interfaceClass = StudentService.class,version = "1.0.0",check = false)
    private StudentService studentService;

    @RequestMapping("/student/count")
    public @ResponseBody Object studentCount(){
        Integer allstudentCount = studentService.queryAllStudentCount();
        return "学生总人数为:"+allstudentCount;
    }
}
