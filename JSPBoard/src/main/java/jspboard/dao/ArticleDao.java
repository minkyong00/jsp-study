package jspboard.dao;

import java.util.List;

import jspboard.model.Article;

public interface ArticleDao {

	public default List<Article> selectArticle() throws Exception{return null;};
	
	public default Article selectArticle(int aid) throws Exception{return null;};
	
	public default int insertArticle(Article article) throws Exception{return 0;};
	
	public default int updateArticle(Article article) throws Exception{return 0;};
	
	public default int deleteArticle(int aid) throws Exception{return 0;};
	
}
