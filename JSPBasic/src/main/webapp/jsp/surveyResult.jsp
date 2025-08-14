<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 아래와 같이 설문조사 결과를 화면에 출력
  [누구누구]님의 설문결과는 다음과 같습니다.
  1. 가장 존경하는 인물은 홍길동
  2. 좋아하는 과일을 복숭아 -->
  
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name")==null ? "" : request.getParameter("name");
	String respectPerson = request.getParameter("respectPerson")==null ? "" : request.getParameter("respectPerson");
	String fruits = request.getParameter("fruits")==null ? "" : request.getParameter("fruits");
%>

<%=name %>님의 설문조사는 다음과 같습니다.<br>
1. 가장 존경하는 인물은 <%=respectPerson %><br>
2. 좋아하는 과일은 <%=fruits %>