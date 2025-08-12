package myservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	
	private void requestProcess(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println(req.getMethod() + "요청 접수!");
		String name = req.getParameter("name");
		String kor = req.getParameter("kor");
		String eng = req.getParameter("eng");
		String math = req.getParameter("math");
		System.out.println(name + "님의 총점은 " 
				+ (Integer.parseInt(kor) + Integer.parseInt(math) + Integer.parseInt(eng)) + "입니다");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// post 방식의 request 인코딩
		req.setCharacterEncoding("utf-8");
		requestProcess(req, resp);
	}
	
}
