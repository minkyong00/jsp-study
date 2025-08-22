<%@page import="jspboard.util.ConnectionUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
	System.out.println(conn!=null ? "연결성공!" : "연결실패!");
%>    
    