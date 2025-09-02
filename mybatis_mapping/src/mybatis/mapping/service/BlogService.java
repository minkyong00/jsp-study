package mybatis.mapping.service;

import mybatis.mapping.model.Blog;

public interface BlogService {
	
	public default Blog selectBlogDetails(int blog_id) throws Exception{
		return null;
	}

}
