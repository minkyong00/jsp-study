package exmvc.command;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListCommand implements PersonCommand {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
		return "/jsp/listPerson.jsp";
	}

}
