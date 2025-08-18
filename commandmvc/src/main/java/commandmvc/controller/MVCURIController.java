package commandmvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commandmvc.handler.CommandHandler;

public class MVCURIController extends HttpServlet {

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

		// 요청 URI
		String requestURI = req.getRequestURI();
		
		// 명령어
		String command = null;
		if(requestURI!=null && requestURI.length()>0 && requestURI.endsWith(".do")) {
			command = requestURI.substring(1).substring(0, requestURI.length()-4);
		}
		
		// 명령어처리클래스명
		String className = "commandmvc.handler." + command.substring(0, 1).toUpperCase()
				+ command.substring(1) +"Command";
		
		try {
			
			// 명령어처리클래스
			Class commandClass = Class.forName(className);
			
			// 명령어처리클래스객체
			CommandHandler commandObj = (CommandHandler)commandClass.newInstance();
			
			// 뷰파일명
			String viewName = "/jsp/" + command + ".jsp";
			
			// 명령 처리
			commandObj.process(req, resp);
			
			// 포워딩
			RequestDispatcher dispatch = req.getRequestDispatcher(viewName);
			dispatch.forward(req, resp);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	} // processRequest

} // class
