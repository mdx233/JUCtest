package com.mdx.springboot.service;

import com.mdx.springboot.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> queryAllStudent();

    Student queryStudentById(Integer id);
}
