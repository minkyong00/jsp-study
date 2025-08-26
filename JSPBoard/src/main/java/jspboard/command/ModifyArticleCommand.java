package jspboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.service.ArticleService;
import jspboard.service.BoardService;
import jspboard.service.impl.ArticleServiceImpl;
import jspboard.service.impl.BoardServiceImpl;

public class ModifyArticleCommand implements BoardCommand {

	private BoardService boardService;
	private ArticleService articleService;
	
	public ModifyArticleCommand() {
		this.boardService = new BoardServiceImpl();
		this.articleService = new ArticleServiceImpl();
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int aid = req.getParameter("aid")==null ? 0 : Integer.parseInt(req.getParameter("aid"));
		
		req.setAttribute("boardList", boardService.listBoard());
		req.setAttribute("article", articleService.getArticle(aid));
		
		return "/jsp/article/registArticle.jsp";
	}
	
}
