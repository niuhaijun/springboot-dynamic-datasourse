package com.niu.hikari.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Multiple DataSource Configurer
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Set dynamic DataSource to Application Context
	 */
	@Override
	protected Object determineCurrentLookupKey() {

		if (logger.isDebugEnabled()) {
			logger.debug("=====> Current DataSource is [{}]",
				DynamicDataSourceContextHolder.getDataSourceKey());
		}

		return DynamicDataSourceContextHolder.getDataSourceKey();
	}
}
