package jspboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.service.ArticleService;
import jspboard.service.impl.ArticleServiceImpl;

public class GetArticleCommand implements BoardCommand {

	private ArticleService articleService;
	
	public GetArticleCommand() {
		this.articleService = new ArticleServiceImpl();
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int aid = Integer.parseInt(req.getParameter("aid"));
		
		req.setAttribute("article", articleService.getArticle(aid));
		
		return "/jsp/article/getArticle.jsp";
	}

}
