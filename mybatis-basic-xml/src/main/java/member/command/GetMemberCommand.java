package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.Member;
import member.service.MemberService;
import member.service.impl.MemberServiceImpl;

public class GetMemberCommand implements MemberCommand{
	
	private MemberService memberService;
	
	public GetMemberCommand() {
		this.memberService = new MemberServiceImpl();
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Member member 
			= memberService.getMember(Integer.parseInt(req.getParameter("mid")));
		
		req.setAttribute("member", member);
		
		return "/jsp/getMember.jsp";
	}

}
