package com.example.springboot_04_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class Springboot04DataApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot04DataApplication.class, args);
	}

}
