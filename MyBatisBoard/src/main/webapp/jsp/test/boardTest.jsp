<%@page import="java.util.List"%>
<%@page import="jspboard.model.Board"%>
<%@page import="jspboard.service.impl.BoardServiceImpl"%>
<%@page import="jspboard.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	BoardService boardService = new BoardServiceImpl();

	// registBoard
	/*
	int result = boardService.registBoard(
		new Board(0, "board", null, null)
	);
	out.print(result>0 ? "등록 성공!" : "등록 실패!");
	*/
	
	// listBoard
	
	List<Board> boardList = boardService.listBoard();
	out.print(boardList);
	
	
	//getBoard
	/*
	Board board = boardService.getBoard(1);
	out.print(board);
	*/
	
	// modifyBoard
	/*
	int result = boardService.modifyBoard(
		new Board(1, "board수정", null, null)
	);
	out.print(result>0 ? "수정 성공" : "수정 실패");
	*/
	
	// removeBoard
	/*
	int result = boardService.removeBoard(1);
	out.print(result>0 ? "삭제 성공" : "삭제 실패");
	*/
	
%>