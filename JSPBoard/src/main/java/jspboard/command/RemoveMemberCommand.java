package jspboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.service.MemberService;
import jspboard.service.impl.MemberServiceImpl;

public class RemoveMemberCommand implements BoardCommand{
	
	private MemberService memberService;
	
	public RemoveMemberCommand() {
		this.memberService = new MemberServiceImpl();
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String mid = req.getParameter("mid")==null? "" : req.getParameter("mid");
		
		int result = memberService.removeMember(mid);
		
		req.setAttribute("result", result);
		
		return "/member/listMember.do";
	}

}
