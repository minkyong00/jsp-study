package jspboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jspboard.constant.BoardConstant;
import jspboard.dao.MemberDao;
import jspboard.model.Member;
import jspboard.util.ConnectionUtil;

public class MemberDaoImpl implements MemberDao {
	
	@Override
	public List<Member> selectMember() throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.MEMBER_SELECTLIST_QUERY);
		ResultSet rs = pstmt.executeQuery();
		List<Member> memberList = null;
		if(rs!=null) {
			memberList = new ArrayList<Member>();
			while(rs.next()) {
				Member member = new Member(
					rs.getString("mid"),
					null,
					rs.getString("mname"),
					rs.getTimestamp("mregdate"),
					null
				);
				memberList.add(member);
			}
		}
		ConnectionUtil.close(conn, rs, pstmt);
		return memberList;
	}
	
	@Override
	public Member selectMember(String mid) throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.MEMBER_SELECTONE_QUERY);
		pstmt.setString(1, mid);
		ResultSet rs = pstmt.executeQuery();
		Member member = null;
		if(rs!=null && rs.next()) {
			member = new Member(
				rs.getString("mid"),
				null,
				rs.getString("mname"),
				rs.getTimestamp("mregdate"),
				null
			);
		}
		ConnectionUtil.close(conn, rs, pstmt);
		return member;
	}
	
	@Override
	public int insertMember(Member member) throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.MEMBER_INSERT_QUERY);
		pstmt.setString(1, member.getMid());
		pstmt.setString(2, member.getMpass());
		pstmt.setString(3, member.getMname());
		int result = pstmt.executeUpdate();
		conn.commit();
		ConnectionUtil.close(conn, null, pstmt);
		return result;
	}
	
	@Override
	public int updateMember(Member member) throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.MEMBER_UPDATE_QUERY);
		pstmt.setString(1, member.getMpass());
		pstmt.setString(2, member.getMname());
		pstmt.setString(3, member.getMid());
		int result = pstmt.executeUpdate();
		conn.commit();
		ConnectionUtil.close(conn, null, pstmt);
		return result;
	}
	
	@Override
	public int deleteMember(String mid) throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.MEMBER_DELETE_QUERY);
		pstmt.setString(1, mid);
		int result = pstmt.executeUpdate();
		conn.commit();
		ConnectionUtil.close(conn, null, pstmt);
		return result;
	}
	
}
