package jspboard.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {
	
	private static final String sqlMapConfig = "jspboard/conf/SqlMapConfig.xml";
	private static Reader reader = null;
	private static SqlSessionFactory sqlSessionFactory = null; 
	private SqlSession session = null; 
	
	static {
		try{
			reader = Resources.getResourceAsReader(sqlMapConfig);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession() throws Exception {
		return sqlSessionFactory.openSession();
	}
	
	public static void closeSqlSession(SqlSession sqlSession) throws Exception {
		if(sqlSession!=null) sqlSession.close();
	}
	
} // class
