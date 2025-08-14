<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	request.setCharacterEncoding("utf-8");
	System.out.println("page2 request object: " + request);
	
	// page1.jsp에서 보낸 파라미터
	String paramName = request.getParameter("name")==null ? "" : request.getParameter("name");
	String paramAge = request.getParameter("age")==null ? "" : request.getParameter("age");
	System.out.print("paramName= "+ paramName + ", paramAge= " + paramAge + "<br>");
	
	// page1.jsp에서 설정한 속성 변수
	String attrName = (String)request.getAttribute("name");
	Date attrNow = (Date)request.getAttribute("now");
	System.out.print("attrName= " + attrName + ", attrNow= " + attrNow + "<br>");
	
	// page1 request object: org.apache.catalina.connector.RequestFacade@7c3a2f60 톰캣이 지정한 facade
	// page2 request object: org.apache.catalina.core.ApplicationHttpRequest@6dcc7fca request을 wrapper로 래핑
	
	// 실습 : page3.jsp에 name속성 변수의 값, now속성변수의 값을 파라미터로 전달
	
	
%>

<!-- 
<%-- 
	표현식안에 문자열 넣을 때
	<%=\"abc\"%> 
--%>
-->

<jsp:forward page="page3.jsp">
	<jsp:param name="name" value="<%=attrName%>" />
	<jsp:param name="now" value="<%=attrNow.toString()%>" />
</jsp:forward>
    