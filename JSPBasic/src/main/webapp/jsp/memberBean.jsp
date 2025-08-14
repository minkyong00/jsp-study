<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
	- useBean : useBean action tag, JSP에서 자바빈을 사용
		- id : 빈의 이름
		- class : 빈의 클래스명 (풀네임)
		- scope : 빈객체의 참조 범위 (기본 page)
-->
<jsp:useBean id="member" class="model.Member" scope="request" />

<!-- 
	- setProperty : setProperty action tag, 자바빈의 프라퍼티(멤버변수)의 값을 설정
		- name : 빈의 이름
		- property : 빈의 프라퍼티명
		- value : 설정할 값
-->
<jsp:setProperty name="member" property="mid" value="hong" />     

<!-- 
	- getProperty : getProperty action tag, 자바빈의 프라퍼티(멤버변수)의 값을 획득
		- name : 빈의 이름
		- property : 빈의 프라퍼티명
-->
<jsp:getProperty name="member" property="mid" />

<br><br>

<!-- 위 액션태그에 대한 자바 버전 -->
<%
	/* jsp:useBean */
	
	// Member 빈 생성
	Member mem = new Member();
	// request 속성변수로 설정	
	request.setAttribute("mem", mem);
	
	/* jsp:setProperty */
	mem.setMid("hong");

	/* jsp:getProperty */
	out.print(mem.getMid());
%>



































