package jspboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.model.Member;
import jspboard.service.MemberService;
import jspboard.service.impl.MemberServiceImpl;

public class RegistMemberProcCommand implements BoardCommand {

	private MemberService memberService;

	public RegistMemberProcCommand() {
		this.memberService = new MemberServiceImpl();
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
		throws Exception {
		
		String mid = req.getParameter("mid")==null ? "" : req.getParameter("mid");
		String mpass = req.getParameter("mpass")==null ? "" : req.getParameter("mpass");
		String mname = req.getParameter("mname")==null ? "" : req.getParameter("mname");
		
		memberService.registMember(
			new Member(mid, mpass, mname, null, null)
		);
		
		// get으로 가야하는데 메서드가 post로 오는데
		// listMemberProcCommand은 없기 때문에 
		// listMember.do로 리다이렉션함
		// 리다이랙션하고 컨트롤러에서 forword시키는 에러가 남
		
		// 리다이랙션을 하게 되면 주소가 바껴서
		// 새로고침해서 재등록되는 경우가 없음
		res.sendRedirect("/member/listMember.do");
		
		return "";
	}
	
}
