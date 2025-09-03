package jspboard.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DataSourceUtil {
	
	private static DataSourceUtil dataSourceUtil = new DataSourceUtil();
	private Context ct;
	private DataSource ds;
	
	private DataSourceUtil() {
	}

	public static DataSourceUtil getDataSourceUtil() {
		return dataSourceUtil;
	}
	
	public DataSource getDataSource() throws Exception {
		ct = new InitialContext();
		ds = (DataSource)ct.lookup("java:comp/env/jdbc/mybatisboard");
		return ds;
	}
	
}
