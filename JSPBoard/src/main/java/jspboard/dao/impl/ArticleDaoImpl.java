package jspboard.dao.impl;

import java.util.List;

import jspboard.dao.ArticleDao;
import jspboard.model.Article;

public class ArticleDaoImpl implements ArticleDao {

	@Override
	public List<Article> selectArticle() throws Exception {
		return ArticleDao.super.selectArticle();
	}
	
	@Override
	public Article selectArticle(int aid) throws Exception {
		return ArticleDao.super.selectArticle(aid);
	}
	
	@Override
	public int insertArticle(Article article) throws Exception {
		return ArticleDao.super.insertArticle(article);
	}
	
	@Override
	public int updateArticle(Article article) throws Exception {
		return ArticleDao.super.updateArticle(article);
	}
	
	@Override
	public int deleteArticle(int aid) throws Exception {
		return ArticleDao.super.deleteArticle(aid);
	}
	
}
