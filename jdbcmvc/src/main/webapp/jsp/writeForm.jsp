<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeForm</title>
</head>
<body>
<h3>등록폼</h3>
<form action="/writeProc.do" method="post">
이름: <input type="text" name="pname" /><br>
나이: <input type="text" name="page" /><br>
<input type="button" value="목록" onclick="javascript:location.href='/list.do';" />&nbsp;
<input type="submit" value="등록" />
</form>
</body>
</html>