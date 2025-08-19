<%@page import="exmvc.model.Person"%>
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
<%
	// request 속성변수로 등록됨 리스트 획득
	List<Person> personList = (List<Person>)request.getAttribute("personList");
	
	// 리스트가 있다면
	if (personList!=null && personList.size()>0) {
		// 리스트 사이즈
		int personListSize = personList.size();
		// 리스트 사이즈만큼 반복
		for (int i=0; i<personListSize; i++) {
			// Person객체 획득
			Person person = personList.get(i);
			// 화면에 객체 정보 출력
			out.print("이름: " + person.getName() + ", 나이: " 
				+ person.getAge() + "<br>");
		}
	} else {
		out.print("데이터 없음!");
	}
%>
</body>
</html>









