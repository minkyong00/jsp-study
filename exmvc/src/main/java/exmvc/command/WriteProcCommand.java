package exmvc.command;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteProcCommand implements PersonCommand {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
		return "/jsp/writeProcPerson.jsp";
	}

}
