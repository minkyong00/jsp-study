package jdbcmvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbcmvc.constant.PersonConstant;

public class ConnectionUtil {
	
	// non-static 초기화는 생성자 안에서 함(멤버변수 초기화)
	
	// 드라이버를 계속 로딩할 필요가 없으므로
	// static 초기화 블럭 사용
	static {
		try {
			Class.forName(PersonConstant.JDBC_DRIVER);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	
	public static Connection getConnection() throws Exception {
		
		return DriverManager.getConnection(
			PersonConstant.JDBC_URL,
			PersonConstant.JDBC_USER,
			PersonConstant.JDBC_PASSWORD
		);
		
	}
	
	public static void close(Connection conn, ResultSet rs, Statement stmt)
		throws Exception{
		if(conn!=null) conn.close();
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
	
}
