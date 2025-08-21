package jspboard.service.impl;

import java.util.List;

import jspboard.model.Reply;
import jspboard.service.ReplyService;

public class ReplyServiceImpl implements ReplyService{
	
	@Override
	public List<Reply> listReply() throws Exception {
		return ReplyService.super.listReply();
	}
	
	@Override
	public Reply getReply(int rid) throws Exception {
		return ReplyService.super.getReply(rid);
	}
	
	@Override
	public int registReply(Reply reply) throws Exception {
		return ReplyService.super.registReply(reply);
	}
	
	@Override
	public int modifyReply(Reply reply) throws Exception {
		return ReplyService.super.modifyReply(reply);
	}
	
	@Override
	public int removeReply(int rid) throws Exception {
		return ReplyService.super.removeReply(rid);
	}

}
