<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:out value="Hello JSTL!" /><br>    

<%@ page import="model.Person" %>

<!--
c:set 태그 : 변수를 설정
속성 : var:변수명, value:변수값, scope:영역
      target:객체, property:객체프라퍼티명

c:out 태그 : 출력
속성 : value:출력할 변수나 값, escapeXml:파싱할지 여부
-->
<c:set var="varName1" value="홍길동" />
<c:out value="${varName1}" /><br>
<c:set var="varName2" value='<%="홍길동"%>' />
<c:out value="${varName2}" /><br>
<c:set var="varName3" value="${'홍길동'}" />
<c:out value="${varName3}" /><br>
<c:set var="varName4" value="${varName1}" />
<c:out value="${varName4}" /><br>

<c:set var="varName5">
	<input type="button" name="btn" value="클릭" />
</c:set>
<c:out value="${varName5}" /><br>
<c:out value="${varName5}" escapeXml="true" /><br>
<c:out value="${varName5}" escapeXml="false" /><br>

<%
	Person person = new Person("홍길동", 30);
	pageContext.setAttribute("person", person);
%>

<c:set target="${person}" property="name" value="강감찬" />
<c:set target="${person}" property="age" value="40" />
<c:out value="${person.name}" /><br>
<c:out value="${person.age}" /><br>

<c:set var="varName6" value="pageVal" scope="page" />
<c:set var="varName6" value="requestVal" scope="request" />
<c:set var="varName6" value="sessionVal" scope="session" />
<c:set var="varName6" value="applicationVal" scope="application" />
<c:out value="${varName6}" /><br>
<c:out value="${pageScope.varName6}" /><br>
<c:out value="${requestScope.varName6}" /><br>
<c:out value="${sessionScope.varName6}" /><br>
<c:out value="${applicationScope.varName6}" /><br>

<!--
c:remove 태그: 변수 제거
속성 : var:제거할 변수명, scope:영역
-->
<c:remove var="varName6" scope="session" />
<c:out value="${pageScope.varName6}" /><br>
<c:out value="${requestScope.varName6}" /><br>
<c:out value="${sessionScope.varName6}" /><br>
<c:out value="${applicationScope.varName6}" /><br>

<!--
c:if 태그: 조건식
속성: test:조건식
-->
<c:set var="varName6" value="3" />
<c:if test="${varName6>5}" >
	varName6는 5보다 큽니다<br>
</c:if>
<c:if test="${!(varName6>5)}" >
	varName6는 5보다 크지 않습니다<br>
</c:if>

<!--
c:choose 태그: 조건 선택

c:when 태그: 각 조건일 때 수행할 코드
속성: test:조건식

c:otherwise : 위 모든 조건이 false일 때 수행할 코드
-->
<c:set var="varName7" value="17" />
<c:choose>
	<c:when test="${varName7<10}">
		열살 미만입니다<br>
	</c:when>
	<c:when test="${varName7<20}">
		스무살 미만입니다<br>
	</c:when>
	<c:when test="${varName7<30}">
		서른살 미만입니다<br>
	</c:when>
	<c:otherwise>
		서른살 이상입니다<br>
	</c:otherwise>
</c:choose>

<!--
c:forEach 태그: 반복
속성 : var:반복시 값을 저장할 변수명, items:반복할 배열/리스트/맵
      varStatus:반복상태를 저장할 변수명, begin:반복시작값, end:반복종료값, step:반복시증가값
-->
${list = ["apple", "pear", "orange", "kiwi", "banana"];''}
<c:forEach var="eachFruit" items="${list}" varStatus="stat">
	요소: <c:out value="${eachFruit}" />,
	첫번째: <c:out value="${stat.first}" />,
	마지막: <c:out value="${stat.last}" />,
	현재: <c:out value="${stat.current}" /><br>
</c:forEach>

<c:forEach var="i" begin="1" end="100" step="2">
	<c:out value="${i+=' '}" />
</c:forEach>

<br>

<!--
c:forTokens 태그: 구분자(delimeter)를 기준으로 분할해서 반복
속성 : var:토큰저장할 변수, items:반복할 문자열
      delims: 구분자, varStatus:반복상태저장변수명
-->
${fruits = "apple,pear,orange,kiwi,banana";''}
<c:forTokens var="token" items="${fruits}" delims="," varStatus="stat">
	<c:out value="${stat.index}" /> : 
	<c:out value="${stat.count}" /> : 
	<c:out value="${token+=' '}" /><br>
</c:forTokens>

<!-- 실습 : 구구단 출력 -->
<c:forEach var="i" begin="2" end="9">
	<br>
	<c:forEach var="j" begin="1" end="9">
		<c:out value="${i+='*'+=j+='='+=i*j+=' '}" />
	</c:forEach>
</c:forEach>

<br><br>

<!-- 삼각별 출력
oo*oo
o***o
*****
-->
<c:set var="starCount" value="3" />
<c:forEach var="i" begin="1" end="${starCount}">
	<c:forEach var="j" begin="1" end="${starCount-i}">o</c:forEach>
	<c:forEach var="j" begin="1" end="${2*i-1}">*</c:forEach>
	<c:forEach var="j" begin="1" end="${starCount-i}">o</c:forEach>
	<br>
</c:forEach>

<br><br>

<!--
c:url 태그: URL 생성
-->
<c:url var="naverUrl" value="https://www.naver.com" />
${naverUrl}<br>

<!--
c:import 태그 : URL의 코드를 가져오는 태그
-->
<%--
<c:import var="googleHtml" url="https://www.google.com" charEncoding="utf-8" />
${googleHtml}<br>
<c:import url="https://www.naver.com" charEncoding="utf-8" />
 --%>
 
<!--
c:redirect 태그: 리다이렉션

c:param 태그 : 파라미터변수명과 변수값을 지정
-->
<c:redirect url="/jsp/redirectPage.jsp" context="/">
	<c:param name="a" value="1" />
	<c:param name="b" value="1" />
</c:redirect>




















