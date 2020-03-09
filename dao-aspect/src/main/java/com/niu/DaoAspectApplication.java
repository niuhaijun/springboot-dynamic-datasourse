package com.niu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 基于DAO层方法名进行数据源切换
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement
@MapperScan({"com.niu.common.mapper"})
public class DaoAspectApplication {

	public static void main(String[] args) {

		SpringApplication.run(DaoAspectApplication.class, args);
	}

}
