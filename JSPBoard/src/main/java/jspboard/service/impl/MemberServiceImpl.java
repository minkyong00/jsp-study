package jspboard.service.impl;

import java.util.List;

import jspboard.dao.MemberDao;
import jspboard.dao.impl.MemberDaoImpl;
import jspboard.model.Member;
import jspboard.service.MemberService;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}
	
	@Override
	public List<Member> listMember() throws Exception {
		return memberDao.selectMember();
	}
	
	@Override
	public Member getMember(String mid) throws Exception {
		return memberDao.selectMember(mid);
	}
	
	@Override
	public int registMember(Member member) throws Exception {
		return memberDao.insertMember(member);
	}
	
	@Override
	public int modifyMember(Member member) throws Exception {
		return memberDao.updateMember(member);
	}

	@Override
	public int removeMember(String mid) throws Exception {
		return memberDao.deleteMember(mid);
	}
	
}
