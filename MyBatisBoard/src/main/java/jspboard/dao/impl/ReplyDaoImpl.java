package jspboard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jspboard.dao.ReplyDao;
import jspboard.model.Reply;
import jspboard.util.SqlSessionUtil;

public class ReplyDaoImpl implements ReplyDao{

	@Override
	public List<Reply> selectReply(int aid) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		List<Reply> replyList = session.selectList("jspboard.model.selectListReply", aid);
		SqlSessionUtil.closeSqlSession(session);
		return replyList;
	}
	
	@Override
	public Reply getReply(int rid) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		Reply reply = session.selectOne("jspboard.model.selectOneReply", rid);
		SqlSessionUtil.closeSqlSession(session);
		return reply;
	}
	
	@Override
	public int insertReply(Reply reply) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int result = session.insert("jspboard.model.insertReply", reply);
		session.commit();
		SqlSessionUtil.closeSqlSession(session);
		return result;
	}
	
	@Override
	public int updateReply(Reply reply) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int result = session.update("jspboard.model.updateReply", reply);
		session.commit();
		SqlSessionUtil.closeSqlSession(session);
		return result;
	}
	
	@Override
	public int deleteReply(int rid) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int result = session.update("jspboard.model.deleteReply", rid);
		session.commit();
		SqlSessionUtil.closeSqlSession(session);
		return result;
	}
	
}
