package com.mdx.springboot.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mdx.springboot.model.Student;
import com.mdx.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class StudentController {

    @Reference(interfaceClass = StudentService.class,version = "1.0.0",check = false)
    private StudentService studentService;

    @RequestMapping("/Student")
    public String selectAll(Model model){
       List<Student> list = studentService.queryAllStudent();
        model.addAttribute("list",list);
        return "StudentList";
    }

    @RequestMapping("/Student/{id}")
    public String selectById(Model model,
                             @PathVariable("id") Integer id){
        Student student = studentService.queryStudentById(id);
        model.addAttribute("student",student);
        return "Student";
    }

}
