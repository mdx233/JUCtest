package com.mdx.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.mdx.springboot.service.StudentService;
import org.springframework.stereotype.Component;

@Component
//暴露接口,类似于dubbo的配置：<dubbo:service interface="" version="" timeout=""/>
@Service(interfaceClass = StudentService.class,version = "1.0.0",timeout = 15000)

public class StudentServiceImpl implements StudentService {
    @Override
    public Integer queryAllStudentCount() {
        return 1024;
    }
}
