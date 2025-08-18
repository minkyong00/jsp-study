package commandmvc.handler;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteCommand implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServerException, IOException {
		return "/jsp/write.jsp";
	}
	
}
