package jspboard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jspboard.dao.BoardDao;
import jspboard.model.Board;
import jspboard.util.SqlSessionUtil;

public class BoardDaoImpl implements BoardDao {

	@Override
	public List<Board> selectBoard() throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		List<Board> boardList = session.selectList("jspboard.model.selectListBoard");
		SqlSessionUtil.closeSqlSession(session);
		return boardList;
	}
	
	@Override
	public Board selectBoard(int bid) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		Board board = session.selectOne("jspboard.model.selectOneBoard", bid);
		SqlSessionUtil.closeSqlSession(session);
		return board;
	}
	
	@Override
	public int insertBoard(Board board) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int result = session.insert("jspboard.model.insertBoard", board);
		session.commit();
		SqlSessionUtil.closeSqlSession(session);
		return result;
	}
	
	@Override
	public int updateBoard(Board board) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int result = session.update("jspboard.model.updateBoard", board);
		session.commit();
		SqlSessionUtil.closeSqlSession(session);
		return result;
	}
	
	@Override
	public int deleteBoard(int bid) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int result = session.update("jspboard.model.deleteBoard", bid);
		session.commit();
		SqlSessionUtil.closeSqlSession(session);
		return result;
	}
	
}
