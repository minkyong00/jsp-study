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

		// 1. 요청 URI => /writeForm.dㅇ
		// 2. 요청URI => /writeProc.do
		// 3. 요청URI => /list.do
		String requestURI = req.getRequestURI();
		
		// 명령어 저장 변수
		String command = null;
		
		// 올바른 URI 확인
		if (requestURI!=null && requestURI.length()>0 && requestURI.endsWith(".do")) {
			
			// 1. 명령어 추출 => writeForm
			// 2. 명령어 추출 => writeProc
			// 3. 명령어 추출 => list
			command = requestURI.substring(1).substring(0, req.getRequestURI().length()-4);
		
		}
		
		// 1. 명령어 처리 클래스명 => exmvc.command.WriteFormCommand
		// 2. 명령어 처리 클래스명 => exmvc.command.WriteProcCommand
		// 3. 명령어 처리 클래스명 => exmvc.command.ListCommand
		String className = "exmvc.command." + command.substring(0, 1).toUpperCase() 
			+ command.substring(1) +"Command";
		
		try {
			// 명령어 처리클래스
			Class commandClass = Class.forName(className);
			
			// 명령어 처리클래스의 객체를 생성
			PersonCommand commandObj = (PersonCommand)commandClass.newInstance();
			
			// 명령어 처리클래스 객체의 process메소드를 호출하고 뷰경로
			String viewName = commandObj.process(req, resp);
			
			// 뷰경로로 포워딩
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewName);
			dispatcher.forward(req, resp);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
		
	}

}







