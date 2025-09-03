<%@page import="jspboard.model.Reply"%>
<%@page import="jspboard.service.impl.ReplyServiceImpl"%>
<%@page import="jspboard.model.Afile"%>
<%@page import="jspboard.service.impl.AfileServiceImpl"%>
<%@page import="jspboard.model.Article"%>
<%@page import="jspboard.service.impl.ArticleServiceImpl"%>
<%@page import="jspboard.model.Member"%>
<%@page import="jspboard.service.impl.MemberServiceImpl"%>
<%@page import="jspboard.model.Board"%>
<%@page import="jspboard.service.impl.BoardServiceImpl"%>
<%@page import="jspboard.service.BoardService"%>
<%@page import="jspboard.util.ConnectionUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	// Board
	//System.out.println(new BoardServiceImpl().getBoard(21));
	
	//new BoardServiceImpl().listBoard().stream().forEach(System.out::println);
	
	// Board board = new Board(0, "유머게시판", null, null);
	// int result = new BoardServiceImpl().registBoard(board);
	// System.out.println(result>0 ? "등록성공" : "등록실패");
	
	//Board board = new Board(2, "board1수정", null, null);
	//int result = new BoardServiceImpl().modifyBoard(board);
	//System.out.println(result>0 ? "수정성공" : "수정실패");
	
	//int result = new BoardServiceImpl().removeBoard(2);
	//System.out.println(result>0 ? "삭제성공" : "삭제실패");
	
	
	// Member
	// new MemberServiceImpl().listMember().stream().forEach(System.out::println);
	
	// System.out.println(new MemberServiceImpl().getMember("kang"));
	
	//Member member = new Member("kang", "1524", "강감찬", null, null);
	//int result = new MemberServiceImpl().modifyMember(member);
	//System.out.println(result>0 ? "수정성공" : "수정실패");
	
	//int result = new MemberServiceImpl().removeMember("hong1");
	//System.out.println(result>0 ? "삭제성공" : "삭제실패");
	
	//Member member = new Member("kang", "1524", "강감찬", null, null);
	//System.out.println(new MemberServiceImpl().loginMember(member));
	
	// new MemberServiceImpl().latestListMember().stream().forEach(System.out::println);
	
	
	//Article
	 // System.out.println(new ArticleServiceImpl().getArticle(11565));
	
	//Article article = new Article(0, "test12", "test12", null, 0, 0, null, "kang", 42, "유머게시판");
	//int result = new ArticleServiceImpl().registArticle(article);
	//System.out.println(result>0 ? "등록성공" : "등록실패");
	
	//Article article = new Article(5211, "ㅋㅋasdf", "ㅋㅋㅋadfadf", null, 0, 0, null, "kang", 42, "유머게시판");
	//int result = new ArticleServiceImpl().modifyArticle(article);
	//System.out.println(result>0 ? "수정성공" : "수정실패");
	
	//int result = new ArticleServiceImpl().removeArticle(3211);
	//System.out.println(result>0 ? "삭제성공" : "삭제실패");
	
	//System.out.println(new ArticleServiceImpl().getNextAid());
	
	//System.out.println(new ArticleServiceImpl().getTotalArticleCount("", ""));
	
	// new ArticleServiceImpl().listArticle("", "", 1).stream().forEach(System.out::println);
	
	// new ArticleServiceImpl().latestListArticle().stream().forEach(System.out::println);
	
	
	// Afile
	// new AfileServiceImpl().listAfile(5151).stream().forEach(System.out::println);
	
	//System.out.println(new AfileServiceImpl().getAfile(75));
	
	//Afile afile = new Afile(0, "서버파일이름", "클라이언트파일이름", "image/jpeg", null, "N", "kang", 11567);
	//int result = new AfileServiceImpl().registAfile(afile);
	//System.out.println(result>0 ? "등록성공" : "등록실패");
	
	//Afile afile = new Afile(88, "서버파일이름수정", "클라이언트파일이름수정", "image/jpeg", null, "N", "kang", 5211);
	//int result = new AfileServiceImpl().modifyAfile(afile);
	//System.out.println(result>0 ? "수정성공" : "수정실패");
	
	//int result = new AfileServiceImpl().removeOneAfile(88);
	//System.out.println(result>0 ? "삭제성공" : "삭제실패");
	
	//int result = new AfileServiceImpl().removeAllAfile(4831);
	//System.out.println(result>0 ? "삭제성공" : "삭제실패");
	
	//new AfileServiceImpl().latestListAfile().stream().forEach(System.out::println);
	
	
	// Reply
	// new ReplyServiceImpl().listReply(4641).stream().forEach(System.out::println);
	
	// System.out.println(new ReplyServiceImpl().getReply(21));
	
	//Reply reply = new Reply(0, "dd", null, null, "kang", 4641);
	//int result = new ReplyServiceImpl().registReply(reply);
	//System.out.println(result>0 ? "등록성공" : "등록실패");
	
	//Reply reply = new Reply(61, "dddasfkjlk", null, null, "kang", 4641);
	//int result = new ReplyServiceImpl().modifyReply(reply);
	//System.out.println(result>0 ? "수정성공" : "수정실패");
	
	//int result = new ReplyServiceImpl().removeReply(61);
	//System.out.println(result>0 ? "삭제성공" : "삭제실패");
	
%>    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    