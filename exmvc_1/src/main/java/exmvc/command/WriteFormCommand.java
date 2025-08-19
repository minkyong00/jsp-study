package exmvc.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteFormCommand implements PersonCommand {
	
	public String process(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		return "/jsp/writeForm.jsp";
	}

}
