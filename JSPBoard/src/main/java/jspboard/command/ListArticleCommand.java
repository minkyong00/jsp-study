package jspboard.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.model.Article;
import jspboard.service.ArticleService;
import jspboard.service.impl.ArticleServiceImpl;

public class ListArticleCommand implements BoardCommand {
	
	private ArticleService articleService;
	
	public ListArticleCommand() {
		this.articleService = new ArticleServiceImpl();
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		List<Article> articleList = articleService.listArticle();
		req.setAttribute("articleList", articleList);
		
		if(articleList!=null) {
			req.setAttribute("articleCount", articleList.size());
		} else {
			req.setAttribute("articleCount", 0);
		}
		
		return "/jsp/article/listArticle.jsp";
	}

}
