package com.mdx.springboot.StudentService.imp;

import com.mdx.springboot.StudentService.StudentService;
import com.mdx.springboot.mapper.StudentMapper;
import com.mdx.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
