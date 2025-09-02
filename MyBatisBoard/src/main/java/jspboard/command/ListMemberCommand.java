package jspboard.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.model.Member;
import jspboard.service.MemberService;
import jspboard.service.impl.MemberServiceImpl;

public class ListMemberCommand implements BoardCommand{

	private MemberService memberService;
	
	public ListMemberCommand() {
		this.memberService = new MemberServiceImpl();
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		List<Member> memberList = memberService.listMember();
		req.setAttribute("memberList", memberList);
		
		if(memberList!=null) {
			req.setAttribute("allMemberCount", memberList.size());
			req.setAttribute("activeMemberCount", 
				memberList.stream().filter(m -> m.getMdelyn().equals("N")).count());
		} else {
			req.setAttribute("allMemberCount", 0);
			req.setAttribute("activeMemberCount", 0);
		}
		
		return "/jsp/member/listMember.jsp";
	}

}
