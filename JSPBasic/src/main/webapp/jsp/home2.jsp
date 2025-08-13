<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home2</title>
</head>
<body>

<%
	// 직접 URL을 입력해서 페이지에 접근하는 것을 방지
	if (session==null || session.getAttribute("sess_uid")==null){
		response.sendRedirect("loginForm2.jsp");
	}
%>

[<%=session.getAttribute("sess_uid") %>]님 로그인 중!<br><br>
<a href="/logoutProc">[로그아웃]</a>

</body>
</html>