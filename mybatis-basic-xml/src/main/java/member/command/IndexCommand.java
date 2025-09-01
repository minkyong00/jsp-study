package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexCommand implements MemberCommand{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		res.sendRedirect("/listMember.do");
		
		return "";
	}

}
