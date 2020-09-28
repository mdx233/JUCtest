package com.mdx;

import com.mdx.dao.StudentDao;
import com.mdx.entity.Student;
import com.mdx.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class StudentTest {
    public static void main(String[] args) {
        //通过工具类获取sqlSession对象
        MyBatisUtils myBatisUtils = new MyBatisUtils();
        SqlSession sqlSession = myBatisUtils.getSqlSession();
        //使用mybatis动态代理方法
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentlist = studentDao.selectStudents();
        //输出结果
        for (Student stu : studentlist){
            System.out.println(stu);
        }

    }
}

