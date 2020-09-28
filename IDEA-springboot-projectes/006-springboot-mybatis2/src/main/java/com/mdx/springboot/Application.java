package com.mdx.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//开启spring配置
@SpringBootApplication
//开启扫描mapper接口的包以及子目录
@MapperScan(basePackages = "com.mdx.springboot.mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
