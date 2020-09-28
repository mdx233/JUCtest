package com.example.springboot_05_mybatis.controller;

import com.example.springboot_05_mybatis.mapper.UserMapper;
import com.example.springboot_05_mybatis.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @GetMapping("/userlist")
    public List<user> QueryUserList(){
        List<user> userList = userMapper.queryUserList();
        return userList;
    }

    /*public user QueryUserById(Integer id){
        user user = userMapper.queryUserById(id);
        return user;
    }



    public int updateUser(user user){
        int result = userMapper.updateUser(user);
        return result;
    }*/

    @GetMapping("/adduser")
    public String addUser(){
        int result = userMapper.addUser();
        return result > 0 ?"redirect:/userlist":"redirect:/error";
    }

    @ResponseBody
    @GetMapping("/error")
    public String error(){
        return "增加失败！";
    }


    @GetMapping("/deluser/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        int result = userMapper.deleteUser(id);
        return "redirect:/userlist";
    }
}
