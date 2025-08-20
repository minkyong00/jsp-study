package jdbcmvc.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DataSourceUtil {
	
	/* 
	 싱글톤 패턴 : 객체를 하나만 만들어서 밖에서 객체 생성못하고 필요할때 getInstance로 제공함
	 - private static 멤버변수
	 - private 생성자
	 - public static 타입 getInstance 메소드
	*/
	
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
		ds = (DataSource)ct.lookup("java:comp/env/jdbc/oracle");
		return ds;
	}
	
}
