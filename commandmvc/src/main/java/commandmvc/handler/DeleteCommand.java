package commandmvc.handler;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCommand implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServerException, IOException {
		return "/jsp/delete.jsp";
	}
	
}
