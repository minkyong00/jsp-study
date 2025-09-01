package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.Member;
import member.service.MemberService;
import member.service.impl.MemberServiceImpl;

public class UpdateMemberCommand implements MemberCommand{
	
	private MemberService memberService;
	
	public UpdateMemberCommand() {
		memberService = new MemberServiceImpl();
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String mid = req.getParameter("mid");
		
		Member member = memberService.getMember(Integer.parseInt(mid));
		req.setAttribute("member", member);
		
		return "/jsp/insertMember.jsp";
	}

}
