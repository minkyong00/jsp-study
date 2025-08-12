<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>attributeVariable1</title>
</head>
<body>

<%
	application.setAttribute("aav", new Date());
	session.setAttribute("sav", new Date());
	request.setAttribute("rav", new Date());
	pageContext.setAttribute("pav", new Date());

	// redirection (request가 새롭게 생성 = 기존 request는 사라짐)
	// 웹브라우져 주소창의 URL이 변경됨
	// 클라이언트가 attributeVariable1.jsp을 요청 > 서버에서 attributeVariable2.jsp를 요청하라고 응답
	// > 클라이언트는 attributeVariable2.jsp를 요청 > 서버에서는 응답
	
	response.sendRedirect("attributeVariable2.jsp");
	
	//forwarding(request를 유지)
	// 페이지 이동하면서 정보를 가지고 있으려면 forwarding 사용
	// 웹브라우져 주소창의 URL이 유지됨
	// 클라이언트가 attributeVariable1.jsp을 요청 > 서버에서 attributeVariable2.jsp로 요청을 전달
	// > 서버에서는 응답
	
	// RequestDispatcher rd = request.getRequestDispatcher("attributeVariable2.jsp");
	// rd.forward(request, response);
%>

</body>
</html>