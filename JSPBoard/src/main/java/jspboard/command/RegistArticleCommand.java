package jspboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.service.BoardService;
import jspboard.service.impl.BoardServiceImpl;

public class RegistArticleCommand implements BoardCommand {

	private BoardService boardService;
	
	public RegistArticleCommand() {
		this.boardService = new BoardServiceImpl();
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// 서버사이드 렌더링
		req.setAttribute("boardList", boardService.listBoard());
		
		return "/jsp/article/registArticle.jsp";
	}
	
}
