<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	request.setCharacterEncoding("utf-8"); 
%>

<!-- 설문 응시자명 입력받고 다음 버튼 클릭시 survey2.jsp페이지로 이동 -->

<form action="survey2_2.jsp" method="post">
	설문 응시자명: <br>
	<input type="text" name="name" /><br>
	<button type="submit">다음</button>
</form>

