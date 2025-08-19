<%@page import="jdbcmvc.constant.PersonConstant"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Class.forName(PersonConstant.JDBC_DRIVER);
	
	Connection conn = DriverManager.getConnection(
		PersonConstant.JDBC_URL, 
		PersonConstant.JDBC_USER, 
		PersonConstant.JDBC_PASSWORD
	);
	
	if(conn!=null){
		out.print("데이터베이스 연결 성공!");
	} else {
		out.print("데이터베이스 연결 실패!");
	}
	
%>