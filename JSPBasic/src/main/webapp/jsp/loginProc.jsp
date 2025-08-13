<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%

	String uid = request.getParameter("uid")==null ? "" : request.getParameter("uid");
	String upass = request.getParameter("upass")==null ? "": request.getParameter("upass");
	
	// 아이디가 hong, 비밀번호가 1234 라면 로그인 성공이라 가정
	// 추후에는 데이터베이스에서 데이터 가져와서 처리
	if(uid.equals("hong") && upass.equals("1234")){
		
		// 로그인 성공
		session.setAttribute("sess_uid", uid);
		response.sendRedirect("home.jsp");
	
	} else {
	
		// 로그인 실패
		response.sendRedirect("loginForm.jsp");
	}

%>