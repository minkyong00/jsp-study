<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my home</title>
</head>
<body>
	
<%
	if(session==null && session.getAttribute("sess_uid")==null){
		response.sendRedirect("myLoginForm.jsp");
	}
%>

[<%=session.getAttribute("sess_uid")%>]님 로그인 중! <br><br>
<a href="/myLogoutProc">로그아웃</a>
	
</body>
</html>