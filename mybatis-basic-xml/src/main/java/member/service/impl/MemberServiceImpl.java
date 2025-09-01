package member.service.impl;

import java.util.List;

import member.dao.MemberDao;
import member.dao.impl.MemberDaoImpl;
import member.model.Member;
import member.service.MemberService;

public class MemberServiceImpl implements MemberService{
	
	private MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}
	
	@Override
	public List<Member> listMember() throws Exception {
		return memberDao.listMember();
	}
	
	@Override
	public Member getMember(int mid) throws Exception {
		return memberDao.getMember(mid);
	}
	
	@Override
	public int insertMember(Member member) throws Exception {
		return memberDao.insertMember(member);
	}
	
	@Override
	public int updateMember(Member member) throws Exception {
		return memberDao.updateMember(member);
	}
	
	@Override
	public int deleteMember(int mid) throws Exception {
		return memberDao.deleteMember(mid);
	}

}
