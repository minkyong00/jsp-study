package exmvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exmvc.command.PersonCommand;

public class PersonController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String requestURI = req.getRequestURI();
		String command = null;
		if(requestURI!=null && requestURI.length()>0 && requestURI.endsWith(".do")) {
			command = requestURI.substring(1).substring(0, requestURI.length()-4);
		}
		
		String className = "exmvc.command." + command.substring(0, 1).toUpperCase()
				+ command.substring(1) + "Command";
		
		try {
			Class commandClass = Class.forName(className);
			PersonCommand personCommand = (PersonCommand)commandClass.newInstance();
			
			personCommand.process(req, resp);
			
			String jspPath = "/jsp/" + command + "Person.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(jspPath);
			dispatcher.forward(req, resp);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

}
