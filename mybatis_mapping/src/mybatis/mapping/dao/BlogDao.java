package mybatis.mapping.dao;

import mybatis.mapping.model.Blog;

public interface BlogDao {

	public default Blog selectBlogDetails(int blog_id) throws Exception{
		return null;
	}
}
