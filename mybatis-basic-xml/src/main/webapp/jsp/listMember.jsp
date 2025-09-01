<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>listMember</title>
</head>
<body>
	<p><input type="button" value="등록" onclick="javascript:location.href='/insertMember.do';" /></p>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty memberList}">
			<c:forEach var="member" items="${memberList}">
			<tr>
				<td><a href="/getMember.do?mid=${member.mid}">${member.mid}</a></td>
				<td>${member.mpassword}</td>
				<td>${member.mname}</td>
				<td>${member.memail}</td>
				<td><a href="/updateMember.do?mid=${member.mid}">[수정]</a></td>
				<td><a href="/deleteMember.do?mid=${member.mid}">[삭제]</a></td>
			</tr>
			</c:forEach>
			</c:if>
			<c:if test="${empty memberList}">
			<tr>
				<td colspan="6">등록된 멤버가 없습니다!</td>
			</tr>
			</c:if>
		</tbody>
	</table>	
</body>
</html>























