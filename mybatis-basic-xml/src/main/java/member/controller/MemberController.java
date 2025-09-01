package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.command.MemberCommand;

public class MemberController extends HttpServlet {
	
	private MemberCommand memberCommand;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {

		String requestMethod = req.getMethod();
		String requestURI = req.getRequestURI();
		
		String command = null;

		if (requestURI != null && requestURI.length() > 0 && requestURI.endsWith(".do")) {
			command = requestURI.substring(
						(requestURI.lastIndexOf('/') + 1),
						requestURI.indexOf(".do")
					);
		}

		String proc = requestMethod.equalsIgnoreCase("POST") ? "Proc" : "";
		String className = "member.command." + command.substring(0, 1).toUpperCase() 
			+ command.substring(1) + proc + "Command";

		try {
			
			Class commandClass = Class.forName(className);
			
			MemberCommand commandObj = (MemberCommand) commandClass.newInstance();
			
			String viewName = commandObj.process(req, resp);
			
			if(viewName!=null && !viewName.equals("")) {
				if(!viewName.equals("nofr")) {
					RequestDispatcher dispatcher = req.getRequestDispatcher(viewName);
					dispatcher.forward(req, resp);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // processRequest
	
}
