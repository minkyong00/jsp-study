<%@page import="model.ScoreProc"%>
<%@page import="model.Score"%>
<%@page import="model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- EL 람다함수 -->    
${factorial = (n) -> n==1 ? 1: n*factorial(n-1);''}
${factorial(5)}<br>


<!-- stream() -->
${list = [1, 2, 3]; sum = list.stream().sum();''} <!-- 연산만 하기 -->
${list = [1, 2, 3]; sum = list.stream().sum(); sum}<br> <!-- 출력도 같이 하기 -->

<!-- map() -->
${list2 = [1, 2, 3]; result = list2.stream().map(x-> x*x).toList(); result}<br>

<!-- filter() -->
${list3 = [1, 2, 3, 4, 5]; result = list3.stream().filter(x-> x>2).toList(); result}<br>


<!-- sorted() -->
${list4 = [4, 3, 5, 2, 1]; result = list4.stream().sorted().toList(); result}<br>
${list5 = [4, 3, 5, 2, 1]; result = list5.stream().sorted((x, y)-> x<y?1:-1).toList(); result}<br>

<!-- limit() -->
${list6 = [4, 3, 5, 2, 1]; result = list6.stream().limit(3).toList(); result}<br>

<!-- count() -->
${list7 = [4, 3, 5, 2, 1]; result = list7.stream().count(); result}<br>
${list8 = [4, 3, 5, 2, 1]; result = list8.stream().filter(x->x>2).count(); result}<br>
${list9 = ["hello", "java", "jsp"]; result = list9.stream().filter(x->x.length()>3).count(); result}<br>

<!-- get() : 결과가 있으면 결과를 반환, 없으면 Exception -->
${[1, 2, 3].stream().max().get()}<br>
\${[].stream().max().get()}<br>

<!-- orElse(other) : 결과가 있으면 결과를 반환, 없으면 other를 반환 -->
${[1, 2, 3].stream().max().orElse('최대값이 없습니다!')}<br>
${[].stream().max().orElse('최대값이 없습니다!')}<br>

<!-- orElseGet(람다함수) : 결과가 있으면 결과를 반환, 없으면 람다함수를 수행 -->
${[1, 2, 3].stream().max().orElse(()->-1)}<br>
${[].stream().max().orElseGet(()->-1)}<br>

<!-- ifPresent(람다함수) : 결과가 있으면 람다함수를 수행 -->
${[1, 2, 3].stream().min().ifPresent(x->(minValue=x)); minValue}<br>

<!-- sum(), average(), min(), max() -->
${[1, 2, 3, 4, 5].stream().sum()}<br>
${[1, 2, 3, 4, 5].stream().average().get()}<br>
${[1, 2, 3, 4, 5].stream().min().get()}<br>
${[1, 2, 3, 4, 5].stream().max().get()}<br>

<!-- 
	anyMatch() : 매칭되는 것이 하나라도 있으면 true
	allMatch() : 모두가 매칭되면 true
	noneMatch() : 모두가 매칭되지 않으면 true
-->
${list10 = [1, 3, 2, 4, 7, 6, 8, 9, 0];''}
${list10.stream().anyMatch(x->x>5).get()}<br> 
${list10.stream().allMatch(x->x>5).get()}<br>
${list10.stream().noneMatch(x->x>5).get()}<br>


<%
	Student hong = new Student("홍길동", 20, new Score(100, 80, 90));
	Student kang = new Student("강감찬", 30, new Score(90, 80, 50));
	Student lee = new Student("이순신", 50, new Score(60, 50, 30));
	
	pageContext.setAttribute("hong", hong);
	pageContext.setAttribute("kang", kang);
	pageContext.setAttribute("lee", lee);
	
	ScoreProc scoreProc = new ScoreProc();
	
	pageContext.setAttribute("scoreProc", scoreProc);
%>

<!-- 학생리스트 생성 -->
${list = [hong, kang, lee];''}
${list}<br>

<!-- 실습 -->
국어점수 합계 : ${scoreProc.getSubjectTotal("kor", list)}<br>
영어점수 합계 : ${scoreProc.getSubjectTotal("eng", list)}<br>
수학점수 합계 : ${scoreProc.getSubjectTotal("math", list)}<br>
국어점수 평균 : ${scoreProc.getSubjectAverage("kor", list)}<br>
영어점수 평균 : ${scoreProc.getSubjectAverage("eng", list)}<br>
수학점수 평균 : ${scoreProc.getSubjectAverage("math", list)}<br>

hong 합계 : ${scoreProc.getStudentTotal(hong)}<br>
kang 합계 : ${scoreProc.getStudentTotal(kang)}<br>
lee 합계 : ${scoreProc.getStudentTotal(lee)}<br>
hong 평균 : ${scoreProc.getStudentAverage(hong)}<br>
kang 평균 : ${scoreProc.getStudentAverage(kang)}<br>
lee 평균 : ${scoreProc.getStudentAverage(lee)}<br>

국어 점수가 가장 높은 학생의 이름 : ${list.stream().max((s1, s2) -> s1.score.kor.compareTo(s2.score.kor)).get().name}<br>
수학 점수가 가장 낮은 학생의 이름 : ${list.stream().min((s1, s2) -> s1.score.math.compareTo(s2.score.math)).get().name}<br>
영어 점수가 영어과목평균보다 높은 학생들의 이름 : 
${engAvg = scoreProc.getSubjectAverage("eng", list);''}
${list.stream().filter(s -> s.score.eng > engAvg).map(s-> s.name).toList()}<br>


















