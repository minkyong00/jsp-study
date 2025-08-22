package jspboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jspboard.constant.BoardConstant;
import jspboard.dao.ReplyDao;
import jspboard.model.Reply;
import jspboard.service.ArticleService;
import jspboard.service.MemberService;
import jspboard.service.impl.ArticleServiceImpl;
import jspboard.service.impl.MemberServiceImpl;
import jspboard.util.ConnectionUtil;

public class ReplyDaoImpl implements ReplyDao{

	@Override
	public List<Reply> selectReply() throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.REPLY_SELECTLIST_QUERY);
		ResultSet rs = pstmt.executeQuery();
		List<Reply> replyList = null;
		if(rs!=null) {
			replyList = new ArrayList<Reply>();
			while(rs.next()) {
				Reply reply = new Reply(
					rs.getInt("rid"),
					rs.getString("rcontent"),
					rs.getTimestamp("rregdate"),
					null,
					rs.getString("mid"),
					rs.getInt("aid")
				);
				replyList.add(reply);
			}
		}
		return replyList;
	}
	
	@Override
	public Reply selectReply(int rid) throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.REPLY_SELECTONE_QUERY);
		pstmt.setInt(1, rid);
		ResultSet rs = pstmt.executeQuery();
		Reply reply = null;
		if(rs!=null && rs.next()) {
			reply = new Reply(
				rs.getInt("rid"),
				rs.getString("rcontent"),
				rs.getTimestamp("rregdate"),
				null,
				rs.getString("mid"),
				rs.getInt("aid")
			);
		}
		return reply;
	}
	
	@Override
	public int insertReply(Reply reply) throws Exception {
		MemberService memberService = new MemberServiceImpl();
		ArticleService articleService = new ArticleServiceImpl();
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.REPLY_INSERT_QUERY);
		pstmt.setString(1, reply.getRcontent());
		pstmt.setString(2, memberService.getMember("hong1").getMid());
		pstmt.setInt(3, articleService.getArticle(2).getAid());
		int result = pstmt.executeUpdate();
		conn.commit();
		ConnectionUtil.close(conn, null, pstmt);
		return result;
	}
	
	@Override
	public int updateReply(Reply reply) throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.REPLY_UPDATE_QUERY);
		pstmt.setString(1, reply.getRcontent());
		pstmt.setInt(2, reply.getRid());
		int result = pstmt.executeUpdate();
		conn.commit();
		ConnectionUtil.close(conn, null, pstmt);
		return result;
	}
	
	@Override
	public int deleteReply(int rid) throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.REPLY_DELETE_QUERY);
		pstmt.setInt(1, rid);
		int result = pstmt.executeUpdate();
		conn.commit();
		ConnectionUtil.close(conn, null, pstmt);
		return result;
	}
	
}
