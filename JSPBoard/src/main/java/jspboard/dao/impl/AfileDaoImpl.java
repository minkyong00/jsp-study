package jspboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jspboard.constant.BoardConstant;
import jspboard.dao.AfileDao;
import jspboard.model.Afile;
import jspboard.service.AfileService;
import jspboard.service.ArticleService;
import jspboard.service.MemberService;
import jspboard.service.impl.AfileServiceImpl;
import jspboard.service.impl.ArticleServiceImpl;
import jspboard.service.impl.MemberServiceImpl;
import jspboard.util.ConnectionUtil;

public class AfileDaoImpl implements AfileDao {
	
	@Override
	public List<Afile> selectAfile() throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.AFILE_SELECTLIST_QUERY);
		ResultSet rs = pstmt.executeQuery();
		List<Afile> afileList = null;
		if(rs!=null) {
			afileList = new ArrayList<Afile>();
			while(rs.next()) {
				Afile afile = new Afile(
					rs.getInt("afid"),
					rs.getString("afsfname"),
					rs.getString("afcfname"),
					rs.getTimestamp("afregdate"),
					null,
					rs.getString("mid"),
					rs.getInt("aid")
				);
				afileList.add(afile);
			}
		}
		return afileList;
	}
	
	@Override
	public Afile selectAfile(int afid) throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.AFILE_SELECTONE_QUERY);
		pstmt.setInt(1, afid);
		ResultSet rs = pstmt.executeQuery();
		Afile afile = null;
		if(rs!=null && rs.next()) {
			afile = new Afile(
				rs.getInt("afid"),
				rs.getString("afsfname"),
				rs.getString("afcfname"),
				rs.getTimestamp("afregdate"),
				null,
				rs.getString("mid"),
				rs.getInt("aid")
			);
		}
		return afile;
	}
	
	@Override
	public int insertAfile(Afile afile) throws Exception {
		MemberService memberService = new MemberServiceImpl();
		ArticleService articleService = new ArticleServiceImpl();
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.AFILE_INSERT_QUERY);
		pstmt.setString(1, afile.getAfsfname());
		pstmt.setString(2, afile.getAfcfname());
		pstmt.setString(3, memberService.getMember("hong1").getMid());
		pstmt.setInt(4,  articleService.getArticle(2).getAid());
		int result = pstmt.executeUpdate();
		conn.commit();
		ConnectionUtil.close(conn, null, pstmt);
		return result;
	}
	
	@Override
	public int updateAfile(Afile afile) throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.AFILE_UPDATE_QUERY);
		pstmt.setString(1, afile.getAfcfname());
		pstmt.setString(2, afile.getAfsfname());
		pstmt.setInt(3, afile.getAfid());
		int result = pstmt.executeUpdate();
		conn.commit();
		ConnectionUtil.close(conn, null, pstmt);
		return result;
	}
	
	@Override
	public int deleteAfile(int afid) throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.AFILE_DELETE_QUERY);
		pstmt.setInt(1, afid);
		int result = pstmt.executeUpdate();
		conn.commit();
		ConnectionUtil.close(conn, null, pstmt);
		return result;
	}

}
