<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String name = "홍길동";
%>

<!-- 
	include action tag
	- page에 지정한 리소스를 현재 페이지에 컴파일해서 포함
	- 두 페이지에 동일한 변수를 선언하는 것이 가능
	- 일반적으로 다른 리소스의 수행 결과를 현재 페이지에 포함할 때 사용
	- 출력 스트림을 추가한다고 생각
-->

<jsp:include page="inner1.jsp">
	<jsp:param name="age" value="20" />
</jsp:include>

<!-- 
	include directive
	- file에 지정한 리소스의 코드를 현재 페이지에 포함시키고 함께 컴파일
	- 두 페이지에 동일한 변수를 선언하는 것이 불가능
	- 일반적으로 다른 리소스의 코드를 현재 페이지에 포함할 때 사용
	- 헤더.jsp, 푸터.jsp를 가져올 때 사용 (페이지 분할)
-->
<%--@ include file="inner2.jsp" --%>

