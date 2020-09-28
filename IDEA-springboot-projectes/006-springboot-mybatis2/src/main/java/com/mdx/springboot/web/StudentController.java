package com.mdx.springboot.web;

import com.mdx.springboot.StudentService.StudentService;
import com.mdx.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/student")
    public @ResponseBody Object student(Integer id){
        Student student = studentService.queryStudentById(id);
        return student;
    }

    @RequestMapping("/update")
    public @ResponseBody Object update(Integer id,String name){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        int updateCount = studentService.updateStudetName(student);
        return "修改学生编号为"+id+"的姓名修改解过:"+updateCount;
    }
}
