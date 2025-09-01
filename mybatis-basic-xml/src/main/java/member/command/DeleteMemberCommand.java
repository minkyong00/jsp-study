package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.service.impl.MemberServiceImpl;

public class DeleteMemberCommand implements MemberCommand{

	private MemberService memberService;
	
	public DeleteMemberCommand() {
		this.memberService = new MemberServiceImpl();
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int mid = Integer.parseInt(req.getParameter("mid"));
		
		memberService.deleteMember(mid);
		
		res.sendRedirect("/listMember.do");
		
		return "";
	}
	
	

}
