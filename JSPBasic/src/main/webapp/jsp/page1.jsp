<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	// POST요청에 대해서 한글 인코딩
	request.setCharacterEncoding("utf-8");
	System.out.println("page1 request object: " + request);
	
	// request 속성 변수 설정
	request.setAttribute("name", "홍길동");
	request.setAttribute("now", new Date());

%>

<!-- 
	forward action tag : request를 유지하면서 페이지를 이동
	- page : 포워딩할 페이지
	- name : 포워딩할 때 전달할 파라미터 이름
	- value : 포워딩할 때 전달할 파라미터 값
파라미터는 네트워크에서 왔다갔다 하기 때문에 String밖에 안됨 -->

<!-- jsp forward action tage를 사용한 포워딩 -->
<jsp:forward page="page2.jsp">
	<jsp:param name="name" value="홍길동" />
	<jsp:param name="age" value="20" />
</jsp:forward>

<!-- java 포워딩 : RequestDispatcher를 사용한 포워딩 -->
<%--
	RequestDispatcher rd = request.getRequestDispatcher("page2.jsp?name=홍길동&age=20");
	rd.forward(request, response);
--%>
















    