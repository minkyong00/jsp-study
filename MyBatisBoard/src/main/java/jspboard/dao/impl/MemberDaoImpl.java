package jspboard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jspboard.dao.MemberDao;
import jspboard.model.Member;
import jspboard.util.SqlSessionUtil;

public class MemberDaoImpl implements MemberDao {
	
	@Override
	public List<Member> selectMember() throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		List<Member> memberList = session.selectList("jspboard.model.selectListMember");
		SqlSessionUtil.closeSqlSession(session);
		return memberList;
	}
	
	@Override
	public Member selectMember(String mid) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		Member member = session.selectOne("jspboard.model.selectOneMember", mid);
		SqlSessionUtil.closeSqlSession(session);
		return member;
	}
	
	@Override
	public int insertMember(Member member) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int result = session.insert("jspboard.model.insertMember", member);
		session.commit();
		SqlSessionUtil.closeSqlSession(session);
		return result;
	}
	
	@Override
	public int updateMember(Member member) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int result = session.update("jspboard.model.updateMember", member);
		session.commit();
		SqlSessionUtil.closeSqlSession(session);
		return result;
	}
	
	@Override
	public int deleteMember(String mid) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int result = session.update("jspboard.model.deleteMember", mid);
		session.commit();
		SqlSessionUtil.closeSqlSession(session);
		return result;
	}
	
	@Override
	public Member loginMember(Member member) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		Member loginMember = session.selectOne("jspboard.model.loginMember", member);
		SqlSessionUtil.closeSqlSession(session);
		return loginMember;
	}
	
	
	@Override
	public List<Member> latestListMember() throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		List<Member> latestmemberList = session.selectList("jspboard.model.selectMemberLastlist");
		SqlSessionUtil.closeSqlSession(session);
		return latestmemberList;
	}
}
