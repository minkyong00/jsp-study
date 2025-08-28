package jspboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspboard.model.Member;
import jspboard.service.MemberService;
import jspboard.service.impl.MemberServiceImpl;

public class LoginProcCommand implements BoardCommand{

	private MemberService memberService;
	
	public LoginProcCommand() {
		memberService = new MemberServiceImpl();
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// 로그인 처리
		String mid = req.getParameter("mid")==null ? "" : req.getParameter("mid");
		String mpass = req.getParameter("mpass")==null ? "" : req.getParameter("mpass");
		
		Member loginMember = memberService.loginMember(
			new Member(mid, mpass, null, null, null)
		);

		//세션 처리
		if(loginMember!=null) {
			req.getSession().setAttribute("loginMember", loginMember);
		}
		
		return "/main.jsp";
	}

}
