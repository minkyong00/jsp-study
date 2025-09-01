package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.service.impl.MemberServiceImpl;

public class ListMemberCommand implements MemberCommand{
	
	private MemberService memberService;
	
	public ListMemberCommand() {
		this.memberService = new MemberServiceImpl();
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		req.setAttribute("memberList", memberService.listMember());
		
		return "/jsp/listMember.jsp";
	}

}
