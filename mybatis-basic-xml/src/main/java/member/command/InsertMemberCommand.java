package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertMemberCommand implements MemberCommand{
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return "/jsp/insertMember.jsp";
	}

}
