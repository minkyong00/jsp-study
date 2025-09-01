<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getMember</title>
</head>
<body>
	<c:if test="${not empty member}">
		<table>
			<tbody>
				<tr>
					<th>아이디</th>
					<td>${member.mid}</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>${member.mpassword}</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${member.mname}</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${member.memail}</td>
				</tr>
				</c:if>
				<c:if test="${empty member}">
					<tr>
						<td colspan="2">해당 멤버가 없습니다!</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<p><input type="button" value="목록" onclick="javascript:location.href='/listMember.do';" />
</body>
</html>