<%@page import="java.util.LinkedList"%>
<%@page import="member.model.Person"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 출력 -->    
${"Hello EL!!"}<br>

<!-- 속성 변수 접근 -->
<%
	String hello = "Local Hello"; // _jspService메소드 지역변수
	pageContext.setAttribute("hello", "page scope Attr hello"); // page scope 속성변수
%>

<%=pageContext.getAttribute("hello") %><br>
<!-- ${pageScope.hello}<br> pageScope의 hello를 찾음, 굳이 앞에 page 안써도 됨-->
${hello}<br> <!-- page > request > session > application 순으로 찾음 -->

<%
	request.setAttribute("hello", "request scope Attr hello");
%>
${hello}<br>
${pageScope.hello}<br>
${requestScope.hello}<br>


<!-- EL 데이터 타입 -->
boolean: ${false}<br>
number: ${10}<br>
number: ${3.3}<br>
string: ${'hello'}${"hello"}<br>
null: ${null}<br>

<!-- EL 기본 객체 -->
${pageContext}<br> <!-- 구현체 객체: org.apache.jasper.runtime.PageContextImpl@c6ef478 -->
${pageContext.request}<br><br> <!-- request el객체이므로 pageContext.request로 호출함 -->

${pageScope}<br><br>
${requestScope}<br><br>
${sessionScope}<br><br>
${applicationScope}<br><br>

${param.name} ${param.age}<br>
${paramValues}<br><br>

${header}<br> <!-- 요청 헤더 정보 -->
${header.host}<br>
${header['user-agent']}<br>

${cookie}<br>
${cookie.JSESSIONID.value}<br>

${initParam}<br> <!-- 어플리케이션초기화파라미터값 -->

<!-- 객체 접근 -->
<%
	Person person = new Person("홍길동", 30);

	Map<String, String> map = new HashMap<String, String>();
	map.put("entry1", "entry1Value");
	map.put("entry2", "entry2Value");
	map.put("entry3", "entry3Value");
	
	List<String> list = new ArrayList<String>();
	list.add("ele1");
	list.add("ele2");
	list.add("ele3");
	
	String[] strArr = {"hello", "hi", "thankyou"};

	pageContext.setAttribute("person", person);
	pageContext.setAttribute("map", map);
	pageContext.setAttribute("list", list);
	pageContext.setAttribute("strArr", strArr);
%>

<!-- 객체 접근 -->
${person}<br>
${person.name}<br>
${person.age}<br>


<!-- Map 접근 -->
${map}<br>
${map.entry1}<br>
${map.entry2}<br>
${map.entry3}<br>


<!-- List 접근 -->
${list}<br>
${list[0]}<br>
${list[1]}<br>
${list[2]}<br>


<!-- 배열 접근 -->
${strArr}<br>
${strArr[0]}<br>
${strArr[1]}<br>
${strArr[2]}<br>


<!-- 수치 연산자 -->
<%
	pageContext.setAttribute("nullValue", null);
	pageContext.setAttribute("longValue", new Long(100));
	pageContext.setAttribute("floatValue", new Float(3.3));
%>

${longValue + nullValue}<br> <!-- null은 수치연산시 0 -->
${nullValue + 100}<br>
${floatValue + nullValue}<br>
${3.3 + nullValue}<br>

${longValue/nullValue}<br>
${nullValue/longValue}<br>
${floatValue/nullValue}<br>
${nullValue/floatValue}<br>

<!-- 비교 연산자 -->
<%
	pageContext.setAttribute("value1", 20);
	pageContext.setAttribute("value2", 30);
%>
${value1 > value2} ${value1 gt value2} <br>
${value1 < value2} ${value1 lt value2} <br>
${value1 >= value2} ${value1 ge value2} <br>
${value1 <= value2} ${value1 le value2} <br>
${value1 == value2} ${value1 eq value2} <br>
${value1 != value2} ${value1 ne value2} <br>

<!-- 논리연산자 -->
${true && false} ${true and false}<br>
${true || false} ${true or false}<br>

<!-- empty 연산자 -->
<%
	Object obj11 = new Object();
	Object obj22 = null;
	
	Map<String, Object> map11 = new HashMap<String, Object>();
	Map<String, Object> map22 = null;
	Map<String, Object> map33 = new HashMap<String, Object>();
	map33.put("key", "value");
	
	List<String> list11 = new LinkedList<String>();
	List<String> list22 = null;
	List<String> list33 = new LinkedList<String>();
	list33.add("ele");
	
	String[] strArr11 = null;
	String[] strArr22 = new String[10];
	String[] strArr33 = new String[10];
	strArr33[0] = "ele";
	
	pageContext.setAttribute("obj11", obj11);
	pageContext.setAttribute("obj2", obj22);
	pageContext.setAttribute("map11", map11);
	pageContext.setAttribute("map22", map22);
	pageContext.setAttribute("map33", map33);
	pageContext.setAttribute("list11", list11);
	pageContext.setAttribute("list22", list22);
	pageContext.setAttribute("list33", list33);
	pageContext.setAttribute("strArr11", strArr11);
	pageContext.setAttribute("strArr22", strArr22);
	pageContext.setAttribute("strArr33", strArr33);
%>

${empty obj11}<br> <!-- 객체가 있으면 false -->
${empty obj22}<br> <!-- 객체가 null이면 true -->
${empty map11}<br> <!-- 맵 생성만 하고 엔트리가 없으면 true -->
${empty map22}<br> <!-- 맵이 null이면 true -->
${empty map33}<br> <!-- 맵 생성 하고 엔트리가 있으면 false -->
${empty list11}<br> <!-- 리스트 생성만 하고 요소가 없으면 true -->
${empty list22}<br> <!-- 리스트가 null이면 true -->
${empty list33}<br> <!-- 리스트 생성 하고 요소가 있으면 false -->
${empty strArr11}<br> <!-- 배열이 null이면 true -->
${empty strArr22}<br> <!-- 배열 생성하면 false -->
${empty strArr33}<br> <!-- 배열 생성하고 요소가 있으면 false -->

<!-- 삼항 연산자 -->
${3==3 ? "3은 3입니다!" : "3은 3이 아닙니다!"}<br>
${empty map33 ? "map33은 null이거나 엔트리가 없음!" : "map33은 엔트리가 있음!"}<br>
${empty list33 ? "list33은 null이거나 요소가 없음!" : "list33은 요소가 있음!"}<br>


<!-- 문자열 연결 -->
\${"hello" + "world"}<br>
${"hello" +=  "world"}<br>
















