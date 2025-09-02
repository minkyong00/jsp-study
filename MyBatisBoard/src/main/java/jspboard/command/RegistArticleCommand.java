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
		
		String bid = req.getParameter("bid");
		String searchWord = req.getParameter("searchWord");
		String currPageNum = req.getParameter("currPageNum");
		
		// 서버사이드 렌더링
		req.setAttribute("boardList", boardService.listBoard());
		
		req.setAttribute("bid", bid);
		req.setAttribute("searchWord", searchWord);
		req.setAttribute("currPageNum", currPageNum);
		
		return "/jsp/article/registArticle.jsp";
	}
	
}
