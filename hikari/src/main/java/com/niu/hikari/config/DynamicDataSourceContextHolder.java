package com.niu.hikari.config;


import com.niu.common.enums.DataSourceKey;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * Multiple DataSource Context Holder
 */
@Slf4j
public class DynamicDataSourceContextHolder {

	/**
	 * Maintain variable for every thread, to avoid effect other thread
	 */
	private static final ThreadLocal<String> CONTEXT_HOLDER = ThreadLocal
		.withInitial(DataSourceKey.master::name);

	/**
	 * All DataSource List
	 */
	public static List<Object> dataSourceKeys = new ArrayList<>();
	/**
	 * The constant slaveDataSourceKeys.
	 */
	public static List<Object> slaveDataSourceKeys = new ArrayList<>();
	private static int counter = 0;

	/**
	 * Use master data source.
	 */
	public static void useMasterDataSource() {

		CONTEXT_HOLDER.set(DataSourceKey.master.name());
	}

	/**
	 * Use slave data source.
	 */
	public static void useSlaveDataSource() {

		try {
			int datasourceKeyIndex = counter % slaveDataSourceKeys.size();
			CONTEXT_HOLDER.set(String.valueOf(slaveDataSourceKeys.get(datasourceKeyIndex)));
			counter++;
		}
		catch (Exception e) {
			log.error("Switch slave datasource failed", e);
			useMasterDataSource();
		}
	}

	/**
	 * Get current DataSource
	 *
	 * @return data source key
	 */
	public static String getDataSourceKey() {

		return CONTEXT_HOLDER.get();
	}

	/**
	 * To switch DataSource
	 *
	 * @param key the key
	 */
	public static void setDataSourceKey(String key) {

		CONTEXT_HOLDER.set(key);
	}

	/**
	 * To set DataSource as default
	 */
	public static void clearDataSourceKey() {

		CONTEXT_HOLDER.remove();
	}

	/**
	 * Check if give DataSource is in current DataSource list
	 *
	 * @param key the key
	 * @return boolean boolean
	 */
	public static boolean containDataSourceKey(String key) {

		return dataSourceKeys.contains(key);
	}
}
