<%@page import="jdbcmvc.model.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Person person = (Person)request.getAttribute("person");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm</title>
</head>
<body>
<h3>수정폼</h3>
<form action="/updateProc.do" method="post">
<input type="hidden" name="pid" value="<%=person.getPid() %>" />
이름: <input type="text" name="pname" value="<%=person.getPname() %>" /><br>
나이: <input type="text" name="page" value="<%=person.getPage() %>" /><br>
<input type="button" value="목록" onclick="javascript:location.href='/list.do';" />&nbsp;
<input type="submit" value="수정" />
</form>
</body>
</html>