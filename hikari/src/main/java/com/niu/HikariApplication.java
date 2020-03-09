package com.niu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 基于注解实现动态数据源切换
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement
@MapperScan({"com.niu.common.mapper"})
public class HikariApplication {

	public static void main(String[] args) {

		SpringApplication.run(HikariApplication.class, args);
	}

}
