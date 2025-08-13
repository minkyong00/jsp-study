<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie test</title>
</head>
<body>
	
<%
	
	// 쿠키객체 생성
	// name : 쿠키 변수명
	// URLEncoder.encode("name쿠키의 값", "utf-8") : utf-8 인코딩한 쿠키 변수의 값
	Cookie nameCookie 
		= new Cookie("name", URLEncoder.encode("name쿠키의 값", "utf-8"));
	Cookie ageCookie = new Cookie("age", "20");

	// 쿠키를 클라이언트에 발행
	response.addCookie(nameCookie);
	response.addCookie(ageCookie);

%>
	
</body>
</html>