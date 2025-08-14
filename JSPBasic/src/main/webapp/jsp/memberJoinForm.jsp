<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberJoinForm</title>
</head>
<body>

<h3>회원가입폼</h3>

<form name="memberJoinForm" action="memberJoinTest.jsp" method="post">
	아이디: <input type="text" name="mid" /><br>
	비밀번호: <input type="password" name="mpass" /><br>
	회원이름: <input type="text" name="mname" /><br>
	나이: <input type="text" name="mage" /><br>
	휴대폰번호: <input type="text" name="mcp" /><br>
	이메일: <input type="text" name="mem_email" /><br>
	<input type="submit" value="가입하기" />
</form>

</body>
</html>