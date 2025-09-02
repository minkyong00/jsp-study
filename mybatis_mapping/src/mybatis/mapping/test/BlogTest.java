package mybatis.mapping.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.mapping.model.Blog;

public class BlogTest {

	public static void main(String[] args) {
		
		String sqlMapConfig = "mybatis/mapping/conf/SqlMapConfig.xml";
		Reader reader = null;
		SqlSession session = null;
		
		try {
			
			reader = Resources.getResourceAsReader(sqlMapConfig);
			SqlSessionFactory sqlSessionFactory
				= new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			
			Blog blog = session.selectOne("mybatis.mapping.model.selectBlogDetails", 2);
			System.out.println(blog);
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if(session!=null) {
				session.close();
			}
		}
	}
	
}
