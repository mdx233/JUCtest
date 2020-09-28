package com.mdx.springboot.web;

import com.mdx.springboot.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @RequestMapping("/student")
    public @ResponseBody Object student(Integer id){
      Student student = new Student();
      student.setName("zhangsan");
      student.setId(1001);
      return student;
    }

    @GetMapping("/student/detail/{id}/{age}")
    public Object student1(@PathVariable("id") Integer id,
                           @PathVariable("age") Integer age){
        Map<String,Object> remap = new HashMap<>();
        remap.put("id",id);
        remap.put("age",age);
        return remap;
    }

    @PutMapping("/student/detail/{id}/{status}")
    public Object student2(@PathVariable("id") Integer id,
                           @PathVariable("status") Integer status){
        Map<String,Object> remap = new HashMap<>();
        remap.put("id",id);
        remap.put("status",status);
        return remap;
    }

    @PostMapping("/insert")
    //该注解通常用于新增数据
    public Object insert(){
        return "Insert success";
    }
    @GetMapping("/query")
    //该注解通常用于查询数据
    public Object query(){
        return "query Method";
    }

    @DeleteMapping("/delete")
    //该注解通常用于删除数据
    public Object delete(){
        return "delete Method";
    }
    @PutMapping("/update")
    //该注解通常用于修改数据
    public Object update(){
        return "update info";
    }
}
