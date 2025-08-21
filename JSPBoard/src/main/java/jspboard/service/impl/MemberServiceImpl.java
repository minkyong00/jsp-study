package jspboard.service.impl;

import java.util.List;

import jspboard.model.Member;
import jspboard.service.MemberService;

public class MemberServiceImpl implements MemberService {
	
	@Override
	public List<Member> listMember() throws Exception {
		return MemberService.super.listMember();
	}
	
	@Override
	public Member getMember(String mid) throws Exception {
		return MemberService.super.getMember(mid);
	}
	
	@Override
	public int registMember(Member member) throws Exception {
		return MemberService.super.registMember(member);
	}
	
	@Override
	public int modifyMember(Member member) throws Exception {
		return MemberService.super.modifyMember(member);
	}

	@Override
	public int removeMember(String mid) throws Exception {
		return MemberService.super.removeMember(mid);
	}
	
}
