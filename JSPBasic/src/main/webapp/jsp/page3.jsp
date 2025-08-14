<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	String paramName = request.getParameter("name")==null ? "" : request.getParameter("name");
	String paramDateNow = request.getParameter("now")==null ? "" : request.getParameter("now");
	out.print("name= " + paramName + ", paramDateNow= " + paramDateNow);

%>