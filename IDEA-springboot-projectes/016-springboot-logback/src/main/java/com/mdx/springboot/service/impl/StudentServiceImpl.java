package com.mdx.springboot.service.impl;

import com.mdx.springboot.mapper.StudentMapper;
import com.mdx.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Integer queryStudentCount() {
        return studentMapper.queryStudentCount();
    }
}
