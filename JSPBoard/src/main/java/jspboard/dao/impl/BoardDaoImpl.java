package jspboard.dao.impl;

import java.util.List;

import jspboard.dao.BoardDao;
import jspboard.model.Board;

public class BoardDaoImpl implements BoardDao {

	@Override
	public List<Board> selectBoard() throws Exception {
		return BoardDao.super.selectBoard();
	}
	
	@Override
	public Board selectBoard(int bid) throws Exception {
		return BoardDao.super.selectBoard(bid);
	}
	
	@Override
	public int insertBoard(Board board) throws Exception {
		return BoardDao.super.insertBoard(board);
	}
	
	@Override
	public int updateBoard(Board board) throws Exception {
		return BoardDao.super.updateBoard(board);
	}
	
	@Override
	public int deleteBoard(int bid) throws Exception {
		return BoardDao.super.deleteBoard(bid);
	}
	
}
