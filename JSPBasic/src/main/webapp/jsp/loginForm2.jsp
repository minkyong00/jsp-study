<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login form2</title>
</head>
<body>

<form action="/loginProc" method="post">
	아이디 : <input type="text" name="uid" placeholder="아이디를 입력해 주세요!" /><br>
	비밀번호 : <input type="password" name="upass" placeholder="비밀번호를 입력해 주세요!" /><br>
	<input type="submit" value="로그인" />
</form>

</body>
</html>