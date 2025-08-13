<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.Date"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookieExer</title>
</head>
<body>

<%

	// 쿠키 실습
	// jsp 실행시마다 아래 사용자명과 방문회수, 최종 방문시간을 표시
	
	String name = null;
	String sum = "0";
	String time = null;
	
	Cookie[] cookies = request.getCookies();
	int cookiesLength = cookies.length;
	if(cookies != null && cookiesLength > 0){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("name")){
				name = URLDecoder.decode(cookie.getValue(), "utf-8");
			} else if(cookie.getName().equals("sum")){
				sum = cookie.getValue();
			} else if(cookie.getName().equals("time")){
				time = URLDecoder.decode(cookie.getValue(), "utf-8");
			}
		}
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
	
	Cookie nameCookie = new Cookie("name", URLEncoder.encode("홍길동", "utf-8"));
	Cookie countCookie = new Cookie("sum", String.valueOf(Integer.parseInt(sum)+1));
	Cookie timeCookie = new Cookie("time", URLEncoder.encode(sdf.format(new Date()), "utf-8"));
	
	response.addCookie(nameCookie);
	response.addCookie(countCookie);
	response.addCookie(timeCookie);

%>

<%=name %>님 <%=sum %>번째 방문이시군요!<br>
최종 방문시간은 <%=time %>입니다.

</body>
</html>