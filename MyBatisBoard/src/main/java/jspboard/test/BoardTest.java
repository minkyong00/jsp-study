package jspboard.test;

import java.sql.Timestamp;

import jspboard.model.Board;
import jspboard.service.impl.BoardServiceImpl;

public class BoardTest {

	public static void main(String[] args) {

		try {
			// System.out.println(new BoardServiceImpl().registBoard(null));
//			int result = new BoardServiceImpl().registBoard(
//				new Board(0, "유머게시판", null, null)
//			);
//			System.out.println(result>0 ? "등록 성공" : "등록 실패");
			
			new BoardServiceImpl().listBoard().stream().forEach(System.out::println);
		
//			int result = new BoardServiceImpl().modifyBoard(
//				new Board(3, "board2수정", null, null)
//			);
//			System.out.println(result>0 ? "수정 성공!" : "수정 실패!");

//			int result = new BoardServiceImpl().removeBoard(2);
//			System.out.println(result>0 ? "삭제 성공!" : "삭제 실패!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
