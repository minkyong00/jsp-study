<%@page import="member.model.Survey"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 아래와 같이 설문조사 결과를 화면에 출력
  [누구누구]님의 설문결과는 다음과 같습니다.
  1. 가장 존경하는 인물은 홍길동
  2. 좋아하는 과일을 복숭아 -->
  
<%
  request.setCharacterEncoding("utf-8");
  %>

<jsp:useBean id="survey" class="member.model.Survey" scope="request" />

<jsp:setProperty name="survey" property="*" />

<jsp:getProperty name="survey" property="name" />님의 설문조사는 다음과 같습니다.<br>
1. 가장 존경하는 인물은 <jsp:getProperty name="survey" property="respectPerson" /><br>
2. 좋아하는 과일은 <jsp:getProperty name="survey" property="fruits" />

<%=survey.getName() %>님의 설문조사는 다음과 같습니다.<br>
1. 가장 존경하는 인물은 <%=survey.getRespectPerson() %><br>
2. 좋아하는 과일은 <%=survey.getFruits() %>

