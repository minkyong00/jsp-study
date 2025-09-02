package mybatis.mapping.dao.impl;

import org.apache.ibatis.session.SqlSession;

import mybatis.mapping.dao.BlogDao;
import mybatis.mapping.model.Blog;
import mybatis.mapping.util.SqlSessionUtil;

public class BlogDaoImpl implements BlogDao{

	@Override
	public Blog selectBlogDetails(int blog_id) throws Exception {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		Blog blog = sqlSession.selectOne("mybatis.mapping.model.selectBlogDetails", blog_id);
		SqlSessionUtil.closeSqlSession(sqlSession);
		return blog;
	}
	
}
