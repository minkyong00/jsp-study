package jspboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.service.ReplyService;
import jspboard.service.impl.ReplyServiceImpl;

public class RemoveReplyProcCommand implements BoardCommand {
	
	private ReplyService replyService;
	
	public RemoveReplyProcCommand() {
		this.replyService = new ReplyServiceImpl();
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		replyService.removeReply(Integer.parseInt(req.getParameter("rid")));
		
		return "nofr";
	}

}
