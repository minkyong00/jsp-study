<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 이니셜컨텍스트 객체 생성
	Context ct = new InitialContext();
	
	// 이니셜컨텍스트에서 이름으로 객체를 탐색
	DataSource ds = (DataSource)ct.lookup("java:comp/env/jdbc/oracle");
	
	// DataSource로부터 커넥션 획득
	Connection conn = ds.getConnection();
	
	out.print(conn!=null ? "연결 성공!" : "연결 실패!");
	
	if(conn!=null) conn.close();
%>    