package jspboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jspboard.constant.BoardConstant;
import jspboard.dao.ArticleDao;
import jspboard.model.Article;
import jspboard.model.Board;
import jspboard.model.Member;
import jspboard.service.BoardService;
import jspboard.service.MemberService;
import jspboard.service.impl.BoardServiceImpl;
import jspboard.service.impl.MemberServiceImpl;
import jspboard.util.ConnectionUtil;

public class ArticleDaoImpl implements ArticleDao {

	@Override
	public List<Article> selectArticle() throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.ARTICLE_SELECTLIST_QUERY);
		ResultSet rs = pstmt.executeQuery();
		List<Article> articleList = null;
		if(rs!=null) {
			articleList = new ArrayList<Article>();
			while(rs.next()) {
				Article article = new Article(
					rs.getInt("aid"), 
					rs.getString("atitle"),
					rs.getString("acontent"),
					rs.getTimestamp("aregdate"),
					rs.getInt("acount"),
					rs.getInt("afcount"),
					null,
					rs.getString("mid"),
					rs.getInt("bid")
				);
				articleList.add(article);
			}
		}
		return articleList;
	}
	
	@Override
	public Article selectArticle(int aid) throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.ARTICLE_SELECTONE_QUERY);
		pstmt.setInt(1, aid);
		ResultSet rs = pstmt.executeQuery();
		Article article = null;
		if(rs!=null && rs.next()) {
			article = new Article(
				rs.getInt("aid"), 
				rs.getString("atitle"),
				rs.getString("acontent"),
				rs.getTimestamp("aregdate"),
				rs.getInt("acount"),
				rs.getInt("afcount"),
				null,
				rs.getString("mid"),
				rs.getInt("bid")
			);
		}
		return article;
	}
	
	@Override
	public int insertArticle(Article article) throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.ARTICLE_INSERT_QUERY);
		pstmt.setString(1, article.getAtitle());
		pstmt.setString(2, article.getAcontent());
		pstmt.setInt(3, article.getAcount());
		pstmt.setInt(4, article.getAfcount());
		int result = pstmt.executeUpdate();
		conn.commit();
		ConnectionUtil.close(conn, null, pstmt);
		return result;
	}
	
	@Override
	public int updateArticle(Article article) throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.ARTICLE_UPDATE_QUERY);
		pstmt.setString(1, article.getAtitle());
		pstmt.setString(2, article.getAcontent());
		pstmt.setInt(3, article.getAcount());
		pstmt.setInt(4, article.getAfcount());
		pstmt.setInt(5, article.getAid());
		int result = pstmt.executeUpdate();
		conn.commit();
		ConnectionUtil.close(conn, null, pstmt);
		return result;
	}
	
	@Override
	public int deleteArticle(int aid) throws Exception {
		Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstant.ARTICLE_DELETE_QUERY);
		pstmt.setInt(1, aid);
		int result = pstmt.executeUpdate();
		conn.commit();
		ConnectionUtil.close(conn, null, pstmt);
		return result;
	}
	
}
