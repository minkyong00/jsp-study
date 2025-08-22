package jspboard.service.impl;

import java.util.List;

import jspboard.dao.ArticleDao;
import jspboard.dao.impl.ArticleDaoImpl;
import jspboard.model.Article;
import jspboard.model.Board;
import jspboard.model.Member;
import jspboard.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {
	
	private ArticleDao articleDao;
	
	public ArticleServiceImpl() {
		articleDao = new ArticleDaoImpl();
	}

	@Override
	public List<Article> listArticle() throws Exception {
		return articleDao.selectArticle();
	}
	
	@Override
	public Article getArticle(int aid) throws Exception {
		return articleDao.selectArticle(aid);
	}
	
	@Override
	public int registArticle(Article article) throws Exception {
		return articleDao.insertArticle(article);
	}
	
	@Override
	public int modifyArticle(Article article) throws Exception {
		return articleDao.updateArticle(article);
	}
	
	@Override
	public int removeArticle(int aid) throws Exception {
		return articleDao.deleteArticle(aid);
	}
	
}
