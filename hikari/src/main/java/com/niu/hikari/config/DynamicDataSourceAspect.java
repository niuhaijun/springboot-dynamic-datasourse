package com.niu.hikari.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Multiple DataSource Aspect
 */
@Aspect
@Component
@Slf4j
public class DynamicDataSourceAspect {

	/**
	 * Switch DataSource
	 */
	@Before("@annotation(targetDataSource))")
	public void switchDataSource(JoinPoint point, TargetDataSource targetDataSource) {

		if (!DynamicDataSourceContextHolder.containDataSourceKey(targetDataSource.value())) {
			log.error("DataSource [{}] doesn't exist, use default DataSource",
				targetDataSource.value());
		}
		else {
			DynamicDataSourceContextHolder.setDataSourceKey(targetDataSource.value());
			log.info("=====> Switch DataSource to [{}] in Method [{}]",
				DynamicDataSourceContextHolder.getDataSourceKey(), point.getSignature());
		}
	}

	/**
	 * Restore DataSource
	 */
	@After("@annotation(targetDataSource))")
	public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource) {

		DynamicDataSourceContextHolder.clearDataSourceKey();
		log.info("=====> Restore DataSource to [{}] in Method [{}]",
			DynamicDataSourceContextHolder.getDataSourceKey(), point.getSignature());
	}

}
