package com.mdx.springboot.service.impl;

import com.mdx.springboot.StudentService.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public String sayHello() {
        return "Hello!";
    }
}
