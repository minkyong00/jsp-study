package member.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.model.Member;

public class MemberTest {
	
	public static void main(String[] args) {
		
		// SqlMapConfig.xml 파일의 클래스패스상의 경로
		String sqlMapConfig = "member/conf/SqlMapConfig.xml";
		
		// SqlMapConfig.xml 파일의 문자를 읽어들일 스트림
		Reader reader = null;
		
		// SqlSession
		SqlSession session = null;
		
		try {
			
			reader = Resources.getResourceAsReader(sqlMapConfig);
			
			// SqlSessionFactory는 SqlSessionFactoryBuilder를 통해 생성
			SqlSessionFactory sqlSessionFactory
				= new SqlSessionFactoryBuilder().build(reader);
			
			// SqlSession은 SqlSessionFactory를 통해 생성
			session = sqlSessionFactory.openSession();
			
			// insert
//			Member member = new Member(
//				0,
//				"1234",
//				"홍길동",
//				"hong@hong.com"
//			);
//			int result = session.insert("member.model.insertMember", member);
//			session.commit();
//			System.out.println(result>0 ? "등록 성공!" : "등록 실패!");

			// selectList
//			List<Member> memberList = session.selectList("member.model.selectAllMember");
//			memberList.stream().forEach(System.out::println);
			
			// selectOne
//			Member member = session.selectOne("member.model.selectOneMember", 2);
//			System.out.println(member);
			
			// update
//			Member member = new Member(
//				4,
//				null,
//				"홍길동수정",
//				"hong@naver.com"
//			);
//			int result = session.update("member.model.updateMember", member);
//			session.commit();
//			System.out.println(result>0 ? "수정 성공!" : "수정 실패!");
			
			// delete 
//			int result = session.delete("member.model.deleteMember", 11);
//			session.commit();
//			System.out.println(result>0 ? "삭제 성공!" : "삭제 실패!");
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if(session!=null) {
				session.close();
			}
		}
		
	}

}
