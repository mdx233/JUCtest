package com.mdx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	//spring boot项目代码必须放在Application类所在的同级目录或者下级目录
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
