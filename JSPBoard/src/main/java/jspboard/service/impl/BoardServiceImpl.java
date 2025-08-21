package jspboard.service.impl;

import java.util.List;

import jspboard.model.Board;
import jspboard.service.BoardService;

public class BoardServiceImpl implements BoardService {

	@Override
	public List<Board> listBoard() throws Exception {
		return BoardService.super.listBoard();
	}

	@Override
	public Board getBoard(int bid) throws Exception {
		return BoardService.super.getBoard(bid);
	}

	@Override
	public int registBoard(Board board) throws Exception {
		return BoardService.super.registBoard(board);
	}

	@Override
	public int modifyBoard(Board board) throws Exception {
		return BoardService.super.modifyBoard(board);
	}

	@Override
	public int removeBoard(int bid) throws Exception {
		return BoardService.super.removeBoard(bid);
	}

}
