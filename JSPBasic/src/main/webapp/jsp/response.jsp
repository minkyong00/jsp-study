<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response</title>
</head>
<body>

	<%
		out.print(response.getStatus() + "<br>");
		out.print(response.getCharacterEncoding() + "<br>");
		
		// response.setHeader("Content-Type", "application/json; charset=utf-8");
		// response.setHeader("Content-Type", "application/xml; charset=utf-8");
		// response.setHeader("Content-Type", "text/plain; charset=utf-8");
		
		// 클라이언트가 response.jsp 요청 서버에서 리다이렉션
		// index.jsp 다시 요청
		// response.sendRedirect("../index.jsp");
	%>

</body>
</html>