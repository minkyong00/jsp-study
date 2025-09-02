package mybatis.mapping.service.impl;

import mybatis.mapping.dao.BlogDao;
import mybatis.mapping.dao.impl.BlogDaoImpl;
import mybatis.mapping.model.Blog;
import mybatis.mapping.service.BlogService;

public class BlogServiceImpl implements BlogService{

	private BlogDao blogDao;
	
	public BlogServiceImpl() {
		this.blogDao = new BlogDaoImpl();
	}
	
	@Override
	public Blog selectBlogDetails(int blog_id) throws Exception {
		return blogDao.selectBlogDetails(blog_id);
	}
	
}
