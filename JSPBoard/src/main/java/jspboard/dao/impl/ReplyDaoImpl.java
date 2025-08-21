package jspboard.dao.impl;

import java.util.List;

import jspboard.dao.ReplyDao;
import jspboard.model.Reply;

public class ReplyDaoImpl implements ReplyDao{

	@Override
	public List<Reply> selectReply() throws Exception {
		return ReplyDao.super.selectReply();
	}
	
	@Override
	public Reply selectReply(int rid) throws Exception {
		return ReplyDao.super.selectReply(rid);
	}
	
	@Override
	public int insertReply(Reply reply) throws Exception {
		return ReplyDao.super.insertReply(reply);
	}
	
	@Override
	public int updateReply(Reply reply) throws Exception {
		return ReplyDao.super.updateReply(reply);
	}
	
	@Override
	public int deleteReply(int rid) throws Exception {
		return ReplyDao.super.deleteReply(rid);
	}
	
}
