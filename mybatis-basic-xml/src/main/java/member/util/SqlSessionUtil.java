package member.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {
	
	private static final String sqlMapConfig = "member/conf/SqlMapConfig.xml";
	private static Reader reader = null;
	private static SqlSessionFactory sqlSessionFactory = null; // 오라클 하나만 사용하므로 static 붙여도 괜찮음
	private SqlSession session = null; // 쿼리마다 필요함
	
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
