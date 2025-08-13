package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.NoDataException;

public class MyLoginProc extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid")==null ? "" : req.getParameter("uid");
		String upass = req.getParameter("upass")==null ? "" : req.getParameter("upass");
		
		HttpSession session = req.getSession();
		
		String loginErrorCount = (String) session.getAttribute("loginErrorCount");
		if (loginErrorCount==null) {
	         session.setAttribute("loginErrorCount", "0");
	      }
		
		if(uid.equals("") && upass.equals("")) {
			throw new NoDataException();
		} else if(!uid.equals("hong")) {
			session.setAttribute("status", "uidError");
			resp.sendRedirect("/jsp/myLoginForm.jsp");
			increaseLoginErrorCount(session);
		} else if(uid.equals("hong") && !upass.equals("1234")) {
			session.setAttribute("status", "upassError");
			resp.sendRedirect("/jsp/myLoginForm.jsp");
			increaseLoginErrorCount(session);
		} else if(uid.equals("hong") && upass.equals("1234")) {
			session.setAttribute("sess_uid", uid);
			resp.sendRedirect("/jsp/myHome.jsp");
		}
		
	} // doPost
	
	private void increaseLoginErrorCount(HttpSession session) {
	      session.setAttribute("loginErrorCount", 
	            String.valueOf(Integer.parseInt((String)session.getAttribute("loginErrorCount")) + 1));
	   }


	private void alert(HttpServletRequest req, HttpServletResponse resp, String message) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter pw = resp.getWriter();
		pw.print("<script>alert(' " + message + "'); location.href='/jsp/myLoginForm.jsp'; </script>");
		
		
	}
	
}
