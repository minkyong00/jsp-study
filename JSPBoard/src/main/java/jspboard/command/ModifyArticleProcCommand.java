package jspboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.model.Article;
import jspboard.service.ArticleService;
import jspboard.service.impl.ArticleServiceImpl;

public class ModifyArticleProcCommand implements BoardCommand {

	private ArticleService articleService;
	
	public ModifyArticleProcCommand() {
		this.articleService = new ArticleServiceImpl();
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int aid = req.getParameter("aid")==null ? 0 : Integer.parseInt(req.getParameter("aid"));
		String atitle = req.getParameter("atitle")==null ? "" : req.getParameter("atitle");
		String acontent = req.getParameter("acontent")==null ? "" : req.getParameter("acontent");
		int bid = req.getParameter("bid")==null ? 0 : Integer.parseInt(req.getParameter("bid")); 
		
		articleService.modifyArticle(
			new Article(aid, atitle, acontent, null, 0, 0, null, null, bid, null)
		);
		
		res.sendRedirect("/article/getArticle.do?aid=" + aid);
		
		return "";
	}
}
