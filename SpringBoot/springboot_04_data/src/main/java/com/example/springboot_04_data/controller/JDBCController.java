package com.example.springboot_04_data.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库的所有信息
    @GetMapping("/userlsit")
    public List<Map<String,Object>> userLsit(){
        String sql = "select * from user";
        List<Map<String,Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    //增加数据
    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into tiktok.user(username,password,phone,photo,ustate) values('大司马',123,123888,'Java',0)";
        jdbcTemplate.update(sql);
        return "update-ok";
    }

    //修改数据
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update tiktok.user set username=?,password=?,phone=?,photo=?,ustate=? where uid="+id;

        //封装
        Object[] objects = new Object[5];
        objects[0] = "马老师";
        objects[1] = 321;
        objects[2] = 1888888;
        objects[3] = "H5";
        objects[4] = 2;

        jdbcTemplate.update(sql,objects);
        return "update-ok";
    }

    //删除数据
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from tiktok.user where uid =?";
        jdbcTemplate.update(sql,id);
        return "delete-ok";
    }
}
