<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>       

<!-- 
fn:length
fn:contains
fn:containsIgnoreCase
fn:startsWith
fn:endsWith
fn:indexOf
fn:substring
fn:substringBefore
fn:substringAfter
fn:replace
fn:toUpperCase
fn:toLowerCase
fn:trim
fn:split
fn:join
fn:escapeXml
-->

<c:set var="s" value="   Hello JSTL Functions!   " />
<c:set var="csv" value="apple,pear,orange,kiwi,banana" />
<c:set var="htmlFrag" value="<h1><strong>굵게</strong> & <em>기울임</em></h1>" />

문자열의 길이: ${fn:length(s)}<br>
문자열 포함여부: ${fn:contains(s, "JSTL")}<br>
대소문자 구별없이 문자열 포함여부: ${fn:containsIgnoreCase(s, "js")}<br>
특정 문자열로 시작: ${fn:startsWith(s, "Hello")}<br>
특정 문자열로 끝: ${fn:endsWith(s, "Functions!")}<br>
문자열의 인덱스 : ${fn:indexOf(s, "JSTL")}<br>
부분문자열: ${fn:substring(s, 9, 14)}<br>
특정 문자열 앞에 있는 문자열: ${fn:substringBefore(s, "JSTL")}<br>
특정 문자열 뒤에 있는 문자열: ${fn:substringAfter(s, "JSTL")}<br>
문자열 대체 : ${fn:replace(s, " ", "-")}<br>
대문자로: ${fn:toUpperCase(s)}<br>
소문자로: ${fn:toLowerCase(s)}<br>
앞/뒤 공백 제거: ${fn:trim(s)}<br>

<c:set var="tokens" value="${fn:split(csv, ',')}" />
<c:forEach var="token" items="${tokens}" varStatus="st">
	${st.count} : ${fn:trim(token)}<br>
</c:forEach>

${fn:join(tokens, " ")}<br>
${htmlFrag}<br>
${fn:escapeXml(htmlFrag)}<br>





























