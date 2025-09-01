package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.Member;
import member.service.MemberService;
import member.service.impl.MemberServiceImpl;

public class UpdateMemberProcCommand implements MemberCommand{

	private MemberService memberService;
	
	public UpdateMemberProcCommand() {
		this.memberService = new MemberServiceImpl();
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		req.setCharacterEncoding("utf-8");
		
		int mid = Integer.parseInt(req.getParameter("mid"));
		String mpassword = req.getParameter("mpassword");
		String mname = req.getParameter("mname");
		String memail = req.getParameter("memail");
		
		Member member = new Member(mid, mpassword, mname, memail);
		int result = memberService.updateMember(member);
		req.setAttribute("result", result);
		
		res.sendRedirect("/listMember.do");
		
		return "";
	}

}
