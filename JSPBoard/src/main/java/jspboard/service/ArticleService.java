package jspboard.service;

import java.util.List;

import jspboard.model.Article;
import jspboard.model.Board;
import jspboard.model.Member;

public interface ArticleService {

	public default List<Article> listArticle() throws Exception{return null;};
	
	public default Article getArticle(int aid) throws Exception{return null;};
	
	public default int registArticle(Article article) throws Exception{return 0;};
	
	public default int modifyArticle(Article article) throws Exception{return 0;};
	
	public default int removeArticle(int aid) throws Exception{return 0;};
	
}
