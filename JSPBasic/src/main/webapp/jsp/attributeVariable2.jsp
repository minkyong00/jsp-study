<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>attributeVariable2</title>
</head>
<body>

<%
	out.print("application => " + application.getAttribute("aav") + "<br>"); // applicaton이 메모리에 있는 동안 계속
	out.print("session => " + session.getAttribute("sav") + "<br>"); // 톰캣에서 설정한 시간에 따라 계속(기본 30분)
	out.print("request => " + request.getAttribute("rav") + "<br>"); // 리다이렉트하면 null나옴
	out.print("pageContext => " + pageContext.getAttribute("pav") + "<br>"); // attributeVariable1.jsp가 아니면 null
%>

</body>
</html>