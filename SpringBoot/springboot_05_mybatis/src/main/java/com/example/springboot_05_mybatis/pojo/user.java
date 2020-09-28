package com.example.springboot_05_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //setter、getter方法
@AllArgsConstructor //有参构造
@NoArgsConstructor  //无参构造
public class user {
    private String username;
    private String password;
    private String phone;
    private String photo;
    private Integer ustate;
}
