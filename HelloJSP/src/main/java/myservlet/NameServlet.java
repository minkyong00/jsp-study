package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NameServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// name 파라미터의 값을 문자열로 저장
		String name = req.getParameter("name");
		System.out.println(name);
		
		// age 파라미터의 값을 문자열로 저장
		String age = req.getParameter("age");
		System.out.println(age);
		
		// 실습 1: 누구누구님은 십년후에 몇살입니다!를 클라이언트에 전송
//		resp.setContentType("text/html; charset=utf-8");
//		PrintWriter pw = resp.getWriter();
//		pw.append("<!DOCTYPE html>");
//		pw.append("<html>");
//		pw.append("<head>");
//		pw.append("<meta charset='UTF-8'>");
//		pw.append("</head>");
//		pw.append("<body>");
//		pw.append("<h1>" + name);
//		pw.append("님은 십년후에 " + (Integer.parseInt(age) + 10) + "살입니다!");
//		pw.append("</h1>");
//		pw.append("</body>");
//		pw.append("</html>");
//		pw.flush();
//		pw.close();

		// 실습 2 : 클라이언트에서 전달받은 이름과 나이를 
		//         JSON문자열로 변환해서 전송
		
//		resp.setContentType("application/json; charset=utf-8");
//		String json = "[{\"name\":\" "+ name + "\", \"age\": " + age + "}]";
//		PrintWriter pw = resp.getWriter();
//		pw.append(json);
//		pw.flush();
//		pw.close();
		
		// 실습 3 : 클라이언트에서 전달받은 이름과 나이를 
		//         XML문자열로 변환해서 클라이언트에 전송
		
		resp.setContentType("application/xml; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		pw.append("<person>");
		pw.append("<name>" + name + "</name>");
		pw.append("<age>" + age + "</age>");
		pw.append("</person>");
		pw.flush();
		pw.close();
		
	}
	
}
