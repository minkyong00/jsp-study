package simplemvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/controller")
public class MVCController extends HttpServlet {
	
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
		
		// 컨트롤러의 역할
		
		// 1. 클라이언트의 요청을 분석
		String paramRequest = req.getParameter("request")==null ? "" : 
			req.getParameter("request");
		
		// 2. 요청에 따라 결과를 생성하고 결과를 렌더링할 JSP페이지 결정
		Object resultObj = null; // 요청 처리 후 결과를 저장할 객체
		Object viewJSP = null; // 처리 결과를 렌더링할 JSP페이지의 경로
		if(paramRequest.equals("name")) {
			resultObj = "홍길동";
			viewJSP = "/jsp/name.jsp";
		} else if (paramRequest.equals("age")) {
			resultObj = "30";
			viewJSP = "/jsp/age.jsp";
		} else if (paramRequest.equals("hobby")) {
			resultObj = "축구, 농구, 야구";
			viewJSP = "/jsp/hobby.jsp";
		}
		
		req.setAttribute("resultObj", resultObj); // 결과를 request 속성변수에 저장
		
		// 3. 처리 결과를 JSP페이지에 전달
		RequestDispatcher disp = req.getRequestDispatcher((String)viewJSP);
		disp.forward(req, resp);
		
	}
	
} // class



















