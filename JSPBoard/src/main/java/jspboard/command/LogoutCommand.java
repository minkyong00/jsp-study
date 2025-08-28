package jspboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.service.MemberService;
import jspboard.service.impl.MemberServiceImpl;

public class LogoutCommand implements BoardCommand{
	
	private MemberService memberService;
	
	public LogoutCommand() {
		memberService = new MemberServiceImpl();
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// 로그아웃 처리
		memberService.logoutMember(req.getSession());
		
		return "/main.jsp";
	}
	
}
