package jspboard.service;

import java.util.List;

import jspboard.model.Member;

public interface MemberService {
	
	public default List<Member> listMember() throws Exception{return null;};
	
	public default Member getMember(String mid) throws Exception{return null;};
	
	public default int registMember(Member member) throws Exception{return 0;};
	
	public default int modifyMember(Member member) throws Exception{return 0;};
	
	public default int removeMember(String mid) throws Exception{return 0;};

}
