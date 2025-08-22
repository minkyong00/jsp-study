<%@page import="java.util.List"%>
<%@page import="jspboard.service.impl.ArticleServiceImpl"%>
<%@page import="jspboard.service.impl.MemberServiceImpl"%>
<%@page import="jspboard.service.ArticleService"%>
<%@page import="jspboard.service.MemberService"%>
<%@page import="jspboard.model.Afile"%>
<%@page import="jspboard.service.impl.AfileServiceImpl"%>
<%@page import="jspboard.service.AfileService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	AfileService afileService = new AfileServiceImpl();

	// insertAfile
	/*
	int result = afileService.registAfile(
		new Afile(
			0,
			"서버파일이름",
			"클라이언트파일이름",
			null,
			null,
			null,
			0
		)
	);
	out.print(result>0 ? "등록 성공" : "등록 실패");
	*/
	
	//listAfile
	/*
	List<Afile> afileList = afileService.listAfile();
	out.print(afileList);
	*/
	
	//getAfile
	/*
	Afile afile = afileService.getAfile(1);
	out.print(afile);
	*/
	
	// modifyAfile
	/*
	int result = afileService.modifyAfile(
			new Afile(
					1,
					"서버파일이름수정",
					"클라이언트파일이름수정",
					null,
					null,
					null,
					0
			)
	);
	out.print(result>0 ? "수정 성공" : "수정 실패");
	*/
	
	// removeAfile
	/*
	int result = afileService.removeAfile(1);
	out.print(result>0 ? "삭제 성공" : "삭제 실패");
	*/
%>    