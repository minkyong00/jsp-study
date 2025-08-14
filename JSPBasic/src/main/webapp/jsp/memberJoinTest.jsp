<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="member" class="model.Member" scope="request" />

<jsp:setProperty name="member" property="*" />
<!-- 멤버변수명과 form의 name이 다를 경우 param으로 설정해줌 -->
<jsp:setProperty name="member" property="memail" param="mem_email" />
<%--
<jsp:setProperty name="member" property="mpass" />
<jsp:setProperty name="member" property="mname" />
<jsp:setProperty name="member" property="mage" />
<jsp:setProperty name="member" property="mcp" />
<jsp:setProperty name="member" property="memail" />
 --%>
 
아이디: <jsp:getProperty name="member" property="mid" /><br>
비밀번호: <jsp:getProperty name="member" property="mpass" /><br>
이름: <jsp:getProperty name="member" property="mname" /><br>
나이: <jsp:getProperty name="member" property="mage" /><br>
휴대폰번호: <jsp:getProperty name="member" property="mcp" /><br>
이메일주소: <jsp:getProperty name="member" property="memail" /><br>