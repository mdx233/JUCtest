package com.mdx.dao;

import com.mdx.entity.Student;

import java.util.List;

public interface StudentDao {
    //查询所有数据
    public List<Student> selectStudents();

    //新增语句
    //参数类型为Student(即将要输入的数据的实体类)
    //返回值类型为int，代表了成功插入了几行数据
    public int insertStudents(Student student);

    //删除语句
    public  int deleteStudents(Student student);
}
