<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scriptlet</title>
</head>
<body>
	<%
		// scriptlet(스크립트릿)
		// - scriptlet은 _jspService메소드 내부에 들어가는 java코드
		// - 멤버변수, 메소드 선언이 불가능
		// - 스크립트릿에서 선언한 변수는 _jspService메소드의 지역변수
		
		int i = 10;
		String str = "스트립트릿";
		out.print(i + "<br>");
		out.print(str + "<br>");
		
		out.print("<hr>");
		
		// 구구단 출력
		for(int k=2; k<=9; k++){
			for(int j=1; j<=9; j++){
				out.print(k + "*" + j + "=" + k*j + "&nbsp;");
			}
			out.print("<br>");
		}
		
		out.print("<hr>");
		
		// 실습 : 구구단을 테이블에 출력
		out.print("<table><caption>구구단</caption><tbody>");
		for(int k=2; k<=9; k++){
			out.print("<tr>");
			for(int j=1; j<=9; j++){
				out.print("<td>"+ k + "*" + j + "=" + (k*j) +"</td>");
			}
			out.print("</tr>");
		}
		out.print("</table></tbody><br><hr>");
	%>
	
	<table>
		<caption>구구단</caption>
		<tbody>
			<% for(int I=2; I<10; I++){ %>
			<tr>
				<% for(int m=1; m<10; m++){ %>
				<td><%=I + "*" + m + "=" + (I*m) %></td>
				<% } %>
			</tr>
			<% } %>
		</tbody>
	</table>
	
	<hr>
	
	<%-- 
		이 부분은 JSP주석이므로 서버에서 해석하지 않음
		int a = 3;
		int b = 5;
		out.print(a*b);
	--%>
	
	<%
		/* 이 부분은 Java주석이므로 서버에서 해석하지 않음
		int a = 3;
		int b = 5;
		out.print(a*b);
		*/
	%>
	
	<!--
		이 부분은 HTML주석이므로 서버에서 해석함!
		<% 
			int a = 3;
			int b = 5;
			out.print(a*b);
		%>
	-->
	
	<%!
		// declaration (선언식)
		// 서블릿 클래스에서 멤버레벨
		// 멤버변수, 멤버메소드 생성가능
		
		// 멤버변수
		private int pi = 5;
		private String pstr = "declaration";
		
		// 멤버멤소드
		private int add(int a, int b){
			return a + b;
		}
	%>
		
	<%
		out.print(pi + "<br>");
		out.print(pstr + "<br>");
		out.print(add(3, 5));
	%>
		
</body>
</html>























