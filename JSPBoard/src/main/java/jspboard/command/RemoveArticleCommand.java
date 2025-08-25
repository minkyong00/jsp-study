package jspboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.service.ArticleService;
import jspboard.service.impl.ArticleServiceImpl;

public class RemoveArticleCommand implements BoardCommand {
	
	private ArticleService articleService;
	
	public RemoveArticleCommand() {
		this.articleService = new ArticleServiceImpl();
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String aid = req.getParameter("aid")==null ? "" : req.getParameter("aid");
		
		int result = articleService.removeArticle(Integer.parseInt(aid));
		req.setAttribute("result", result);
		
		return "/article/listArticle.do";
	}

}
