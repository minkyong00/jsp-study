<%@page import="java.util.List"%>
<%@page import="jspboard.service.impl.BoardServiceImpl"%>
<%@page import="jspboard.service.BoardService"%>
<%@page import="jspboard.service.impl.MemberServiceImpl"%>
<%@page import="jspboard.service.MemberService"%>
<%@page import="jspboard.model.Article"%>
<%@page import="jspboard.service.impl.ArticleServiceImpl"%>
<%@page import="jspboard.service.ArticleService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ArticleService articleService = new ArticleServiceImpl();

	// insertArticle
	/*
	int result = articleService.registArticle(
		new Article(
			0,
			"제목",
			"내용",
			null,
			0,
			0,
			null,
			null,
			0
		)
	);
	out.print(result>0 ? "등록 성공" : "등록 실패");
	*/
	
	//listArticle
	/*
	List<Article> article = articleService.listArticle();
	out.print(article);
	*/
	
	//getArticle
	/*
	Article article = articleService.getArticle(1);
	out.print(article);
	/*
	
	// modifyArticle
	/*
	int result = articleService.modifyArticle(
			new Article(
				1,	
				"제목수정",
				"내용수정",
				null,
				0,
				0,
				null,
				null,
				0
			)
	);
	out.print(result>0 ? "수정 성공" : "수정 실패");
	*/
	
	// removeArticle
	/*
	int result = articleService.removeArticle(1);
	out.print(result>0 ? "삭제 성공" : "삭제 실패");
	*/
%>    