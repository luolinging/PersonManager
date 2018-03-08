package com.person.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class DataSourceCache {
    private static DataSourceCache instance;
    private DataSource dataSource;
    static {
        instance = new DataSourceCache();
    }
    
    private DataSourceCache() {
        Context context = null;
        try {
            context = new InitialContext();
           	dataSource = (DataSource) context.lookup(
           			"java:comp/env/jdbc/zyxDataSource");
        } catch (NamingException e) {
       		System.out.println("JNDI数据源查找失败，检查配置环境！");
        	e.printStackTrace();
        }
    }
    
    public static DataSourceCache getInstance() {
        return instance;
    }
    
    public DataSource getDataSource() {
       	return dataSource;
    }

}
