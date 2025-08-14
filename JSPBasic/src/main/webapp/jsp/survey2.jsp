<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 가장 존경하는 인물의 이름은? 이름 입력받고 다음 버튼 클릭시 survey3.jsp페이지로 이동 -->

<%
	request.setCharacterEncoding("utf-8"); 
	String name = request.getParameter("name")==null ? "" : request.getParameter("name");
%>

<form action="survey3.jsp" method="post">
	가장 존경하는 인물의 이름은?: <br> 
	<input type="text" name="respectPerson" /><br>
	<input type="hidden" value="<%=name %>" name="name" /><br>
	<button type="submit">다음</button>
</form>

