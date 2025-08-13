<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myLoginForm</title>
</head>
<body>

<%
   String status = (String)session.getAttribute("status");
   String loginErrorCount = (String)session.getAttribute("loginErrorCount");
%>

<form action="/myLoginProc" method="post">
아이디 : <input type="text" name="uid" placeholder="아이디를 입력해 주세요!" /><br>
비밀번호 : <input type="password" name="upass" placeholder="비밀번호를 입력해 주세요!" /><br>
<input id="loginBtn" type="submit" value="로그인">
</form>

<script>
   if ('<%=status%>'!=='null') {
      if ('<%=status%>'==='uidError') {
         alert('아이디가 잘못되었습니다!');
      } else if ('<%=status%>'==='upassError') {
         alert('비밀번호가 잘못되었습니다!');
      }
   }
   if ('<%=loginErrorCount%>'!=='null') {
      if ('<%=loginErrorCount%>'!=='0' && '<%=loginErrorCount%>'!=='5') {
         alert("로그인이 <%=loginErrorCount%>회 실패하였습니다!");
      }
      if ('<%=loginErrorCount%>'==='5') {
         alert("로그인이 5회 실패하였습니다! 10분 후 다시 로그인하세요!");
         document.getElementById("loginBtn").disabled = true;
      }
   }
</script>

</body>
</html>
