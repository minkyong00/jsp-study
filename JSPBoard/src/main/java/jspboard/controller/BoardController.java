package jspboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.command.BoardCommand;

public class BoardController extends HttpServlet {

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

		/*
			requestURI => /member/registMember.do
			
			requestURI.lastIndexOf('/') + 1 => registMember.do
			
			requestURI.substring((requestURI.lastIndexOf('/') + 1), requestURI.indexOf(".do"));
			=> registMember
		*/
		
		if (requestURI != null && requestURI.length() > 0 && requestURI.endsWith(".do")) {
			command = requestURI.substring(
						(requestURI.lastIndexOf('/') + 1),
						requestURI.indexOf(".do")
					);
		}

		String proc = requestMethod.equalsIgnoreCase("POST") ? "Proc" : "";
		String className = "jspboard.command." + command.substring(0, 1).toUpperCase() 
			+ command.substring(1) + proc + "Command";

		try {
			
			Class commandClass = Class.forName(className);
			
			BoardCommand commandObj = (BoardCommand) commandClass.newInstance();
			
			String viewName = commandObj.process(req, resp);
			
			// viewName이 null이면
			// command에서 리다이렉션하고 forward하는 경우가 없음
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
