package jspboard.dao.impl;

import java.util.List;

import jspboard.dao.MemberDao;
import jspboard.model.Member;

public class MemberDaoImpl implements MemberDao {

	@Override
	public List<Member> selectMember() throws Exception {
		return MemberDao.super.selectMember();
	}
	
	@Override
	public Member selectMember(String mid) throws Exception {
		return MemberDao.super.selectMember(mid);
	}
	
	@Override
	public int insertMember(Member member) throws Exception {
		return MemberDao.super.insertMember(member);
	}
	
	@Override
	public int updateMember(Member member) throws Exception {
		return MemberDao.super.updateMember(member);
	}
	
	@Override
	public int deleteMember(String mid) throws Exception {
		return MemberDao.super.deleteMember(mid);
	}
	
}
