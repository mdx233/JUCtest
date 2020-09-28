package com.mdx;

import com.mdx.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class StudentTest {
    public static void main(String[] args) {
        //1.定义mybatis主配置文件的名称，从类路径的根路径开始（target/clasess）
        String config = "mybatis.xml";
        //2.读取这个config表示的文件
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace(); }
        //3.创建了SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.获取SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //6.指定要执行的slq语句的标识。sql映射文件中的namespace + “.” + 标签的id值
        String sqlId = "com.mdx.dao.StudentDao.selectStudents";
        //7.执行sql语句，通过sqlId找到语句
        List<Student> studentlist = sqlSession.selectList(sqlId);
        //8.输出结果
        for (Student stu : studentlist){
            System.out.println(stu);
        }
        //9.关闭sqlSession对象
        sqlSession.close();



    }
}

