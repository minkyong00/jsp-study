<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>servletVariable</title>
</head>
<body>

<%!
	// 서블릿클래스의 static 멤버변수
	private static int psmv = 1;

	// 서블릿클래스의 non-static 멤버변수
	private int pnsmv = 2;
%>
	
<%
	// _jspService 메소드의 지역변수
	int lv = 3;
%>

<%
	// rpv는 _jspService 메소드의 지역변수
	// name은 request parameter 변수의 이름
	String rpv = request.getParameter("name");
%>

<%
	// application 초기화 파라미터
	// 웹어플리케이션이 메모리에 로딩될 때 메모리에 등록되는 변수
	// 웹어플리케이션에서 처음부터 끝까지 전체적으로 사용할 값을 저장
	// web.xml에 설정해서 사용
	// <context-param>
  		// <param-name>aip</param-name>
  		// <param-value>어플리케이션초기화파라미터값</param-value>
  	// </context-param>
	String aipv = application.getInitParameter("aip");
%>

<%
	// servlet 초기화 파라미터 (init될 때 저장됨)
	// web.xml에 설정해서 사용
	// <servlet>
	// 	<servlet-name>NameServlet</servlet-name>
	// 	<servlet-class>myservlet.NameServlet</servlet-class>
	//  <init-param>
	//  	<param-name>sip</param-name>
	//  	<param-value>서블릿초기화파라미터값</param-value>
	//  </init-param>
	// </servlet>
	String sipv = pageContext.getServletConfig().getInitParameter("sip");
%>

<%
	// filter 초기화 파라미터 (init될 때 저장됨)
	// web.xml에 설정해서 사용
	// <filter>
	// 	<filter-name>EncodingFilter</filter-name>
	// 	<filter-class>myfilter.EncodingFilter</filter-class>
	//  <init-param>
	//  	<param-name>fip</param-name>
	//  	<param-value>필터초기화파라미터값</param-value>
	//  </init-param>
	// </filter>

	// jsp에서는 접근 불가능
	// Filter 인터페이스를 구현한 Filter클래스의 init메소드의 FilterConfig 파라미터를 통해서 접근 가능 
	// String fip = filterConfig.getInitParameter("fip");
%>

<%
	// 속성 변수 (attribute variable)
	// application, session, request, pageContext 내장객체에 설정해서 사용하는 변수
	// 변수를 어떤 범위에서 참조할 수 있는지
	// application > session > request > pageContext 보통 이런 범위임
	
	// 속성 변수 설정
	application.setAttribute("aav", "어플리케이션속성변수의값");
	session.setAttribute("sav", "세션속성변수의값"); // session이 유지되는 동안 담을 변수
	request.setAttribute("rav", "요청속성변수의값"); // request가 유지되는 한 사용할 수 있는 변수
	pageContext.setAttribute("pcav", "페이지컨텍스트속성변수의값");
	
	// 속성 변수값 획득
	// 반환타입이 object이므로 string 형변환
	String aav = (String)application.getAttribute("aav");
	String sav = (String)session.getAttribute("sav");
	String rav = (String)request.getAttribute("rav");
	String pcav = (String)pageContext.getAttribute("pcav");
%>
	
</body>
</html>














