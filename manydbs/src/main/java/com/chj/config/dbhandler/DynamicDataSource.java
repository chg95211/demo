package com.chj.config.dbhandler;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
	private static String defaultDataSource;

    @Override
    protected Object determineCurrentLookupKey() {
        // 从自定义的位置获取数据源标识
    	Object dataSource = DynamicDataSourceHolder.getDataSource();
    	if(dataSource==null)
    		return defaultDataSource;
        return DynamicDataSourceHolder.getDataSource();
    }

	public static String getDefaultDataSource() {
		return defaultDataSource;
	}

	public static void setDefaultDataSource(String dataSource) {
		defaultDataSource = dataSource;
	}
    
    
}
