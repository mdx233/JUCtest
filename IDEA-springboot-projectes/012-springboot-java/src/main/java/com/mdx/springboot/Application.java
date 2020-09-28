package com.mdx.springboot;

import com.mdx.springboot.StudentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	StudentService studentService;

	public static void main(String[] args) {

		/**
		 * 第一种实现普通java方法的方式
		 * SpringBoot程序启动后，返回值是ConfiureableApplicationContext,它也是一个spring容器
		 * 它其实相当于原来Spring容器中启动容器ClasspathXmlApplicationContext
		 */

		// //获取Springboot容器
		// ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		//
		// //从spring容器中获取指定的bean对象
		// StudentService studentService = (StudentService) applicationContext.getBean("studentServiceImpl");
		//
		// //调用业务方法
		// String sayHello = studentService.sayHello();
		// System.out.println(sayHello);

		/**
		 * 第二种实现普通java方法的方式
		 * 使Application实现CommandLineRunner接口，并重写该接口的run方法，自动注入java类，在run方法中调用java类中的方法
		 */
		SpringApplication.run(Application.class,args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(studentService.sayHello());

	}
}
