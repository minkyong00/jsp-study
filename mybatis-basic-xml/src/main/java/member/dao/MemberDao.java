package member.dao;

import java.util.List;

import member.model.Member;

public interface MemberDao {

	public default List<Member> listMember() throws Exception{
		return null;
	} 

	public default Member getMember(int mid) throws Exception{
		return null;
	}
	
	public default int insertMember(Member member) throws Exception{
		return 0;
	}

	public default int updateMember(Member member) throws Exception{
		return 0;
	}

	public default int deleteMember(int mid) throws Exception{
		return 0;
	}
	
}
