<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>embededObject</title>
</head>
<body>
	
	<%
		// javax.servlet.http.HttpServletRequest
		out.print(request + "<br>");
		// javax.servlet.http.HttpServletResponse
		out.print(response + "<br>");
		// javax.servlet.jsp.JspWriter
		out.print(out + "<br>");
		// javax.servlet.http.HttpSession
		out.print(session + "<br>");
		// javax.servlet.ServletContext
		out.print(application + "<br>");
		// javax.servlet.jsp.PageContext
		out.print(pageContext + "<br>"); // page의 환경정보
		// javax.servlet.jsp.HttpJspPage
		out.print(page + "<br>"); // page의 객체
		// javax.servlet.ServletConfig
		out.print(config);
	%>
	
</body>
</html>