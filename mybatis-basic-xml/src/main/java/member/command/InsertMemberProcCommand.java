package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.Member;
import member.service.MemberService;
import member.service.impl.MemberServiceImpl;

public class InsertMemberProcCommand implements MemberCommand{
	
	private MemberService memberService;
	
	public InsertMemberProcCommand() {
		memberService = new MemberServiceImpl();
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		req.setCharacterEncoding("utf-8");
		
		String mpassword = req.getParameter("mpassword");
		String mname = req.getParameter("mname");
		String memail = req.getParameter("memail");
		
		Member member = new Member(0, mpassword, mname, memail);
		int result = memberService.insertMember(member);

		req.setAttribute("result", result);
		
		res.sendRedirect("/listMember.do");
		
		return "";
	}

}
