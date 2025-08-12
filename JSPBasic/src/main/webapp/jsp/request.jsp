<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request</title>
</head>
<body>
	
	<%
		out.print(request.getContextPath() + "<br>");
		out.print(request.getMethod() + "<br>");
		out.print(request.getServerName() + "<br>");
		out.print(request.getServerPort() + "<br>");
		out.print(request.getRequestURL() + "<br>");
		out.print(request.getRequestURI() + "<br>");
		out.print(request.getRemoteAddr() + "<br>");
		out.print(request.getProtocol() + "<br>");
		out.print(request.getParameter("name") + "<br>");
		String[] hobbyArr = request.getParameterValues("hobby");
		if(hobbyArr != null){
			for(int i=0; i<hobbyArr.length; i++){
				out.print(hobbyArr[i] + "&nbsp;");
			}
		}
		
		out.print(request.getHeader("Cookie") + "<br>");
		out.print(request.getHeader("User-Agent"));
	%>
	
</body>
</html>