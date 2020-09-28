package com.mdx.dao;

import com.mdx.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    //查询所有数据
    public List<Student> selectStudents();

    //新增语句
    //参数类型为Student(即将要输入的数据的实体类)
    //返回值类型为int，代表了成功插入了几行数据
    public int insertStudents(Student student);

    //传入简单参数
    //接收数据占位符为#{任意名称}
    public Student selectStudentById(Integer id);

    //多个参数：命名参数，在形参定义的前面加入@Param("自定义参数名称")
    public Student selectMultiParam(@Param("myname")String name,@Param("myage")Integer age);

    //使用resultMap
    public List<Map> selectResultMap(Integer id);
}
