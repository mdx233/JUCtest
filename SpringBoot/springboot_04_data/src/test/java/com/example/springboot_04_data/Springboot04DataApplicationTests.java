package com.example.springboot_04_data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot04DataApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() {
		//查看一下默认的数据配置
		System.out.println(dataSource.getClass());

		//获得数据库链接 class com.zaxxer.hikari.HikariDataSource
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}finally {
			if(connection!=null){
				//关闭
				try {
					connection.close();
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}

		}
		;
	}

}
