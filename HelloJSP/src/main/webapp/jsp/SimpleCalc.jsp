<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>간단한 연산</title>
</head>
<body>
	<%
		// SimpleCalc_jsp.java의 _jspService 메소드의 지역변수
		int i = 10;
		int j = 20;
		int sum = i + j;
		System.out.println("합계: " + sum); // 서버 콘솔에 출력, PrintStream out
		out.println("합계: " + sum); // 클라이언트 출력 스트림, JspWriter out (웹브라우저에 찍음(응답))
	%>
</body>
</html>