<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="isModify" value="${not empty member}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${isModify ? 'updateMember' : 'insertMember'}</title>
</head>
<body>
	<form action="${isModify ? '/updateMember.do' : '/insertMember.do'}" method="post">
		<table>
			<tbody>
				<tr>
					<th>비밀번호</th>
					<c:if test="${isModify}"><input type="hidden" name="mid" value="${member.mid}" /></c:if>
					<td><input type="text" name="mpassword" 
						<c:if test="${isModify}">value="${member.mpassword}"</c:if> /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="mname" value="${member.mname}" 
						<c:if test="${isModify}">value="${member.mname}"</c:if> /></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="memail" value="${member.memail}" 
						<c:if test="${isModify}">value="${member.memail}"</c:if> /></td>
				</tr>
			</tbody>
		</table>
		<p>
			<button>${isModify ? '수정' : '등록'}</button>
		</p>
	</form>
</body>
</html>