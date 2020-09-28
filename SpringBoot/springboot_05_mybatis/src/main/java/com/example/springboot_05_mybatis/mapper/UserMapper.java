package com.example.springboot_05_mybatis.mapper;

import com.example.springboot_05_mybatis.pojo.user;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//这个注解表示了这是一个mybatis的mapper类：Dao
@Mapper
@Repository
public interface UserMapper {

    List<user> queryUserList();

    user queryUserById(int id);

    int addUser();

    int updateUser(user user);

    int deleteUser(int id);

}
