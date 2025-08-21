package jspboard.service.impl;

import java.util.List;

import jspboard.model.Article;
import jspboard.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	@Override
	public List<Article> listArticle() throws Exception {
		return ArticleService.super.listArticle();
	}
	
	@Override
	public Article getArticle(int aid) throws Exception {
		return ArticleService.super.getArticle(aid);
	}
	
	@Override
	public int registArticle(Article article) throws Exception {
		return ArticleService.super.registArticle(article);
	}
	
	@Override
	public int modifyArticle(Article article) throws Exception {
		return ArticleService.super.modifyArticle(article);
	}
	
	@Override
	public int removeArticle(int aid) throws Exception {
		return ArticleService.super.removeArticle(aid);
	}
	
}
