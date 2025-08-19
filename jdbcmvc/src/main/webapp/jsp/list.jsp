<%@page import="jdbcmvc.model.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<h3>목록</h3>
	<p>등록된 Person의 수: <%=request.getAttribute("personCount") %></p>
	<%
	
		List<Person> personList = (List<Person>)request.getAttribute("personList");
	
		if(personList!=null && personList.size()>0){
			for (Person person : personList){
				
	%>
	<p>
		번호: <%=person.getPid() %>,
		이름: <%=person.getPname() %>,
		나이: <%=person.getPage() %>
		&nbsp;&nbsp;
		<input type="button" value="수정" 
			onclick="javascript:location.href='/updateForm.do?pid=<%=person.getPid() %>';" />
		&nbsp;
		<input type="button" value="삭제" 
			onclick="javascript:location.href='/deleteProc.do?pid=<%=person.getPid() %>';" />
	</p>
	<%		
			}
		} else {
			out.print("등록된 Person이 없습니다!");
		}
	%>
	
	<input type="button" value="등록" onClick="javascript:location.href='/writeForm.do'" />
</body>
</html>