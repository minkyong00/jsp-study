<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%-- errorPage="errorPage.jsp" --%>

<%
	// NullPointerException
	// String name = request.getParameter("name").toUpperCase();

	// ArrayIndexOutOfBoundsException
	// int[] intArr = new int[3];
	// int i = intArr[3];

	// ClassCastException
	// Object obj = new ArrayList();
	// String str = (String)obj;
	
	try {
		int j = 10/0;
	} catch (ArithmeticException ae){
		ae.printStackTrace();
	}
%>   