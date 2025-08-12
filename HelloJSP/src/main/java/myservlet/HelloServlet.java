package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	// 서블릿 최초 호출 시 한번만 실행
	@Override
	public void init() throws ServletException {
		System.out.println("서블릿 초기화됨!");
	}
	
	// 서블릿 호출시 호출시마다 실행
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) 
//			throws ServletException, IOException {
//		System.out.println("서비스 메소드 호출됨!");
//		
//		if(req.getMethod().equalsIgnoreCase("GET")) {
//			System.out.println("GET 요청");
//		} else if(req.getMethod().equalsIgnoreCase("POST")) {
//			System.out.println("POST 요청");
//		}
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("GET 요청 여기서 처리!");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.append("<!DOCTYPE html>");
		pw.append("<html>");
		pw.append("<head>");
		pw.append("<meta charset='UTF-8'>");
		pw.append("</head>");
		pw.append("<body>");
		pw.append("<h1>GET요청 처리결과 응답함</h1>");
		pw.append("</body>");
		pw.append("</html>");
		pw.flush();
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST 요청 여기서 처리!");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("PUT 요청 여기서 처리!");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DELETE 요청 여기서 처리");
	}
	
	// 서블릿이 메모리에서 제거될 때 (서버 종료 직전) 한번만 실행
	@Override
	public void destroy() {
		System.out.println("서블릿 소멸됨!");
	}
	
}
