package member.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.dao.MemberDao;
import member.model.Member;
import member.util.SqlSessionUtil;

public class MemberDaoImpl implements MemberDao{
	
	@Override
	public List<Member> listMember() throws Exception {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		List<Member> memberList = sqlSession.selectList("member.model.selectAllMember");
		SqlSessionUtil.closeSqlSession(sqlSession);
		return memberList;
	}
	
	@Override
	public Member getMember(int mid) throws Exception {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		Member member = sqlSession.selectOne("member.model.selectOneMember", mid);
		SqlSessionUtil.closeSqlSession(sqlSession);
		return member;
	}
	
	@Override
	public int insertMember(Member member) throws Exception {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		int result = sqlSession.insert("member.model.insertMember", member);
		sqlSession.commit();
		SqlSessionUtil.closeSqlSession(sqlSession);
		return result;
	}
	
	@Override
	public int updateMember(Member member) throws Exception {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		int result = sqlSession.update("member.model.updateMember", member);
		sqlSession.commit();
		SqlSessionUtil.closeSqlSession(sqlSession);
		return result;
	}
	
	@Override
	public int deleteMember(int mid) throws Exception {
		SqlSession sqlSession = SqlSessionUtil.getSqlSession();
		int result = sqlSession.delete("member.model.deleteMember", mid);
		sqlSession.commit();
		SqlSessionUtil.closeSqlSession(sqlSession);
		return result;
	}

}
