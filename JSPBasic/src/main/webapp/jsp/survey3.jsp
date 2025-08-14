<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 다음 중 좋아하는 과일은? 1. 사과 2. 복숭아 3. 오렌지
     과일 선택 후 다음 버튼 클릭시 surveyResult.jsp페이지로 이동 -->

<%
	request.setCharacterEncoding("utf-8");

	// 파라미터 : 클라이언트가 서버에게 보내는 요청 데이터(파라미터)
	// 속성변수 : 서버상에 있는 객체, 서블릿의 객체
	String name = request.getParameter("name")==null ? "" : request.getParameter("name");
	String respectPerson = request.getParameter("respectPerson")==null ? "" : request.getParameter("respectPerson");
%>

<!-- form를 submit하면 새로운 request가 나옴 -->
<form action="surveyResult.jsp" method="post">
	다음 중 좋아하는 과일은? <br>
	<div>
		<input type="radio" id="apple" value="사과" name="fruits" />
		<label for="apple">사과</label>
	</div>
	<div>
		<input type="radio" id="peach" value="복숭아" name="fruits" />
		<label for="peach">복숭아</label>
	</div>
	<div>
		<input type="radio" id="orange" value="오렌지" name="fruits" />
		<label for="orange">오렌지</label>
	</div>
	<input type="hidden" value="<%=name %>" name="name" /><br>
	<input type="hidden" value="<%=respectPerson %>" name="respectPerson" /><br>
	<button type="submit">다음</button>
</form>




