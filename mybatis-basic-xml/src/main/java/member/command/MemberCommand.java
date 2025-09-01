package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberCommand {
	
	public abstract String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception;

}
