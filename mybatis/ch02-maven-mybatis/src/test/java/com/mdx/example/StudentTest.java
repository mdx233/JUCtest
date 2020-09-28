package com.mdx.example;

import com.github.pagehelper.PageHelper;
import com.mdx.dao.StudentDao;
import com.mdx.entity.Student;
import com.mdx.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class StudentTest {
    @Test
    public void testSelectStudentById(){
        MyBatisUtils myBatisUtils = new MyBatisUtils();
        SqlSession sqlSession = myBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student stu = studentDao.selectStudentById(4);
        System.out.println(stu);
        sqlSession.close();

    }

    @Test
    public void testSelectMultiParam(){
        MyBatisUtils myBatisUtils = new MyBatisUtils();
        SqlSession sqlSession = myBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student stu = studentDao.selectMultiParam("张麻子",25);
        System.out.println(stu);
        sqlSession.close();

    }

    @Test
    public void testselectResultMap(){
        MyBatisUtils myBatisUtils = new MyBatisUtils();
        SqlSession sqlSession = myBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Map> stumap = studentDao.selectResultMap(2);
        for(Map stu :stumap){
            System.out.println(stu);
        }

        sqlSession.close();

    }


    @Test
    public void testselectStudents(){
        MyBatisUtils myBatisUtils = new MyBatisUtils();
        SqlSession sqlSession = myBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        //使用PageHelper分页
        //PageHelper.startPage(2,3);
        List<Student> studentList = studentDao.selectStudents();
        for(Student stu :studentList){
            System.out.println(stu);
        }

        sqlSession.close();

    }

    @Test
    public void testinsertStudents(){
        MyBatisUtils myBatisUtils = new MyBatisUtils();
        SqlSession sqlSession = myBatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setAge(20);
        student.setEmail("guanyu@qq.com");
        student.setName("关羽");
        student.setId(2001);

        String s;
        int nums = studentDao.insertStudents(student);
        System.out.println(nums==1 ? "新增成功":"新增失败");

        sqlSession.close();

    }

}
