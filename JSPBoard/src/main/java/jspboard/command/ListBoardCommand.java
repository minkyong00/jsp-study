package jspboard.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.model.Board;
import jspboard.service.BoardService;
import jspboard.service.impl.BoardServiceImpl;

public class ListBoardCommand implements BoardCommand {
	
	private BoardService boardService;

	public ListBoardCommand() {
		this.boardService = new BoardServiceImpl();
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		List<Board> boardList = boardService.listBoard();
		req.setAttribute("boardList", boardList);
		
		if(boardList!=null) {
			req.setAttribute("activeBoardCount", boardList.stream().filter(b -> b.getBdelyn().equals("N")).count());
			req.setAttribute("boardCount", boardList.size());
		} else {
			req.setAttribute("activeBoardCount", 0);
			req.setAttribute("boardCount", 0);
		}
		
		return "/jsp/board/listBoard.jsp";
	}

}
