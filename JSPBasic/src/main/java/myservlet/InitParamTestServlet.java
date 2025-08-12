package myservlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamTestServlet extends HttpServlet {
	
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		
		// 어플리케이션 초기화 파라미터
		// servletContext = application
		String aip = servletConfig.getServletContext().getInitParameter("aip");
		System.out.println(aip);
		
		// 서블릿 초기화 파라미터
		String sip = servletConfig.getInitParameter("sip");
		System.out.println(sip);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
