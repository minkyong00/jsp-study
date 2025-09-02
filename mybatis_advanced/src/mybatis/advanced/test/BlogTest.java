package mybatis.advanced.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.advanced.model.Author;
import mybatis.advanced.model.Blog;
import mybatis.advanced.model.Comm;
import mybatis.advanced.model.CommSearcher;
import mybatis.advanced.util.SqlSessionUtil;

public class BlogTest {

	public static void main(String[] args) {
		
		SqlSession session = null;
		
		try {
			
			session = SqlSessionUtil.getSqlSession();
			
//			List<Blog> blogList = session.selectList("mybatis.advanced.selectBlog");
//			blogList.stream().forEach(System.out::println);
			
//			for(Blog blog : blogList) {
//				System.out.println();
//				System.out.println("블로그아이디: " + blog);
//				System.out.println("블로그작성자: " + blog.getAuthor());
//				blog.getCommList().stream().forEach(System.out::println);
//				System.out.println();
//			}
			
//			CommSearcher commSearcher = new CommSearcher(1, "제목", "내용");
//			List<Comm> commList 
//				= session.selectList("mybatis.advanced.selectCommByBlogId", commSearcher);
//			commList.stream().forEach(System.out::println);
			
//			Comm comm = new Comm(
//				1, "수정댓글제목", "수정댓글내용", 1
//			);
//			int result = session.update("mybatis.advanced.updateComm", comm);
//			session.commit();
//			System.out.println(result>0 ? "수정 성공!" : "수정 실패!");
			
//			List<Integer> commIdList = new ArrayList<Integer>();
//			Collections.addAll(commIdList, 1, 2, 3);
//			
//			List<Comm> commList = session.selectList("mybatis.advanced.selectCommsByCommIds", commIdList);
//			commList.stream().forEach(System.out::println);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(session!=null) SqlSessionUtil.closeSqlSession(session);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	} // main
	
}
