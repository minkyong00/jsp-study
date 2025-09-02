package jspboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.service.BoardService;
import jspboard.service.impl.BoardServiceImpl;

public class RemoveBoardCommand implements BoardCommand {
	
	private BoardService boardService;
	
	public RemoveBoardCommand() {
		this.boardService = new BoardServiceImpl();
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String bid = req.getParameter("bid")==null ? "" : req.getParameter("bid");
		
		int result = boardService.removeBoard(Integer.parseInt(bid));
		req.setAttribute("result", result);
		
		return "/board/listBoard.do";
	}

}
