<%@page import="java.util.List"%>
<%@page import="jspboard.model.Reply"%>
<%@page import="jspboard.service.impl.ReplyServiceImpl"%>
<%@page import="jspboard.service.ReplyService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ReplyService replyService = new ReplyServiceImpl();

	// insertReply
	/*
	int result = replyService.registReply(
		new Reply(
			0,
			"댓글내용",
			null,
			null,
			null,
			0
		)	
	);
	out.print(result>0 ? "등록 성공" : "등록 실패");
	*/
	
	//listReply
	/*
	List<Reply> replyList = replyService.listReply();
	out.print(replyList);
	*/
	
	//getReply
	/*
	Reply reply = replyService.getReply(1);
	out.print(reply);
	*/
	
	// modifyReply
	/*
	int result = replyService.modifyReply(
			new Reply(
					1,
					"댓글내용수정",
					null,
					null,
					null,
					0
				)	
		);
	out.print(result>0 ? "수정 성공" : "수정 실패");
	*/
	
	// removeReply
	/*
	int result = replyService.removeReply(1);
	out.print(result>0 ? "삭제 성공" : "삭제 실패");
	*/
%>        