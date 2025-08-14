<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = "홍길동";
	String age = request.getParameter("age");
	out.print("name= " + name + ", age= " + age);
%>