package jdbcmvc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

public final class ConnectionUtil {
	
	/*
	 connection과 dataSource 분리: 하는 역할이 다름
	*/
	
	private static ConnectionUtil connectionUtil = new ConnectionUtil();
	
	private Connection conn;
	private DataSource ds;
	
	private ConnectionUtil() {
		try {
			this.ds = DataSourceUtil.getDataSourceUtil().getDataSource();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectionUtil getConnectionUtil() {
		return connectionUtil;
	}
	
	public Connection getConnection() throws Exception {
		conn = ds.getConnection();
		return conn;
	}
	
	public void close(Connection conn, ResultSet rs, Statement stmt)
		throws Exception{
		if(conn!=null) conn.close();
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
	
}
