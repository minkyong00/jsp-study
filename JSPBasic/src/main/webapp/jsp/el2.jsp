<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- EL Collection -->    
1. List : ${list=['a', 'b', 'c']}<br>
   list[1] : ${list[1]}<br>

2. Map : ${map={"name":"홍길동", "age": "20"}}<br>
   map.name : ${map.name} ${map["name"]}<br>
   
3. Set : ${set={1,2,3}}<br>
   set[1] : \${set[1]}<br> <!-- set은 index 접근 불가 -->
   
<!-- 세미콜론 연산자 -->
${1+1;2+2}<br> <!-- 연산은 모두 수행하나 출력은 맨 마지막 연산 결과를 출력 -->
${sum1=1+1;sum2=sum1+2}<br>   
${list=[1,2,3]}<br> 
${list=[1,2,3];''}<br> <!-- list 생성은 하나 출력은 안함 -->
   
<!-- 자바객체와 EL 사용 -->   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
       