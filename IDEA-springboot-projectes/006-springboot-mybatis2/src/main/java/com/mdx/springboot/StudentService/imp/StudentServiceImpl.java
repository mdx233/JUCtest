package com.mdx.springboot.StudentService.imp;

import com.mdx.springboot.StudentService.StudentService;
import com.mdx.springboot.mapper.StudentMapper;
import com.mdx.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student queryStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Transactional//开启该方法的事务
    @Override
    public Integer updateStudetName(Student student) {
        //成功
        int i = studentMapper.updateByPrimaryKeySelective(student);
        //失败 如果开启事务则以上对数据库执行的DQL语句执行不成功，事务回滚
        int a = i /0;
        return i;
    }
}
