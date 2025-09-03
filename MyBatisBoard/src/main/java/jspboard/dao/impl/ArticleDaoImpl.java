package jspboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import jspboard.constant.BoardConstant;
import jspboard.dao.ArticleDao;
import jspboard.dto.PageRownum;
import jspboard.model.Article;
import jspboard.util.ConnectionUtil;
import jspboard.util.SqlSessionUtil;

public class ArticleDaoImpl implements ArticleDao {

	@Override
	public List<Article> selectArticle(String bid, String searchWord, int currPageNum)
		throws Exception {
		// 첫 행 rownum
		int startRownum = (currPageNum-1) * BoardConstant.ARTICLE_COUNT_PER_PAGE + 1;
		// 마지막 행 rownum
		int endRownum = currPageNum * BoardConstant.ARTICLE_COUNT_PER_PAGE;
		PageRownum rownum = new PageRownum(bid, searchWord, currPageNum, startRownum, endRownum);
		
		SqlSession session = SqlSessionUtil.getSqlSession();
		List<Article> articleList = session.selectList("jspboard.model.selectListArticle", rownum);
		SqlSessionUtil.closeSqlSession(session);
		return articleList;
	}
	
	@Override
	public Article selectArticle(int aid) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		Article article = session.selectOne("jspboard.model.selectOneArticle", aid);
		SqlSessionUtil.closeSqlSession(session);
		return article;
	}
	
	@Override
	public int insertArticle(Article article) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int result = session.insert("jspboard.model.insertArticle", article);
		session.commit();
		SqlSessionUtil.closeSqlSession(session);
		return result;
	}
	
	@Override
	public int updateArticle(Article article) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int result = session.update("jspboard.model.updateArticle", article);
		session.commit();
		SqlSessionUtil.closeSqlSession(session);
		return result;
	}
	
	@Override
	public int deleteArticle(int aid) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int result = session.update("jspboard.model.deleteArticle", aid);
		session.commit();
		SqlSessionUtil.closeSqlSession(session);
		return result;
	}
	
	@Override
	public int getNextAid() throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int aid = session.selectOne("jspboard.model.nextAid");
		SqlSessionUtil.closeSqlSession(session);
		return aid;
	}
	
	@Override
	public int getTotalArticleCount(String bid, String searchWord) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bid", bid);
		params.put("searchWord", searchWord);
		SqlSession session = SqlSessionUtil.getSqlSession();
		int count = session.selectOne("jspboard.model.getTotalArticleCount", params);
		SqlSessionUtil.closeSqlSession(session);
		return count;
	}
	
	@Override
	public List<Article> latestListArticle() throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		List<Article> articleLatestList = session.selectList("jspboard.model.selectlastlistArticle");
		SqlSessionUtil.closeSqlSession(session);
		return articleLatestList;
	}
	
}
