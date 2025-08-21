<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
    
<!--
fmt:setLocale : 로케일(지역) 설정
fmt:timeZone : 타임존 설정
fmt:formatNumber : 숫자 형식화
fmt:parseNumber : 숫자로 파싱
fmt:formatDate : 날짜/시간 형식화
fmt:parseDate : 날짜/시간으로 파싱
fmt:setBundle : 번들(메세지 모음) 설정
fmt:message : 메세지 설정
fmt:param : 파라미터설정
fmt:requestEncoding : 요청데이터 인코딩
-->    

<fmt:requestEncoding value="utf-8" />

<c:set var="langParam" value="${param.lang}" />
<c:choose>
	<c:when test="${not empty langParam}">
		<fmt:setLocale value="${langParam}" scope="session" />
	</c:when>
	<c:otherwise>
		<fmt:setLocale value="ko_KR" scope="session" />
	</c:otherwise>
</c:choose>

<!--
리소스 번들 설정: /WEB-INF/classes/i18n/messages*.properties, 언어별로 프라퍼티파일이 생김
              브라우저가 어떤 언어에 인지에 따라 언어 객체를 가져옴 -->

<fmt:setLocale value="ko_KR" scope="session" />
<fmt:setBundle basename="i18n.messages" var="msg" />
<p><fmt:message key="name" bundle="${msg}" /></p>
<p><fmt:message key="age" bundle="${msg}" /></p>

<fmt:setLocale value="en_US" scope="session" />
<fmt:setBundle basename="i18n.messages" var="msg" />
<p><fmt:message key="name" bundle="${msg}" /></p>
<p><fmt:message key="age" bundle="${msg}" /></p>

<fmt:setLocale value="ko_KR" scope="session" />

<fmt:formatNumber value="1234.56" /><br>

<c:set var="num1" value="1234567.891" />
<fmt:formatNumber value="${num1}" type="number" /><br>
<!-- 소수점 둘째짜리까지 표시 -->
<fmt:formatNumber value="${num1}" minFractionDigits="2" maxFractionDigits="2" /><br> 
<fmt:formatNumber value="${num1}" groupingUsed="false" /><br>

<fmt:formatNumber value="0.3725" type="percent" /><br>
<fmt:formatNumber value="${num1}" type="currency" /><br>

<fmt:formatNumber value="${num1}" pattern="#,##0.00" /><br>
<fmt:formatNumber value="${num1}" pattern="#,###.000" /><br>

<fmt:parseNumber value="1,234,567,89" type="number" /><br>

<fmt:parseNumber value="1,000" type="number" var="num1" /><br>
<fmt:parseNumber value="1,000" type="number" var="num2" /><br>
두 수의 곱: ${num1*num2}<br>

<c:set var="now" value="<%=new java.util.Date()%>" />
현재 시각 : ${now}<br>
날짜만 길게: <fmt:formatDate value="${now}" type="date" dateStyle="long" /><br>
날짜만 중간: <fmt:formatDate value="${now}" type="date" dateStyle="medium" /><br>
날짜만 짧게: <fmt:formatDate value="${now}" type="date" dateStyle="short" /><br>
시간만 길게: <fmt:formatDate value="${now}" type="time" timeStyle="long" /><br>
시간만 중간: <fmt:formatDate value="${now}" type="time" timeStyle="medium" /><br>
시간만 짧게: <fmt:formatDate value="${now}" type="time" timeStyle="short" /><br>

<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" /><br>
<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" /><br>

<fmt:timeZone value="Asia/Seoul">
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" /><br>
</fmt:timeZone>
<fmt:timeZone value="Austrailia/Sydeny">
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" /><br>
</fmt:timeZone>

<c:set var="dateStr" value="2025-08-21 15:30:00" />
<fmt:parseDate value="${dateStr}" pattern="yyyy-MM-dd HH:mm:ss" var="parsedDate" /><br>
<fmt:formatDate value="${parsedDate}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" /><br>











