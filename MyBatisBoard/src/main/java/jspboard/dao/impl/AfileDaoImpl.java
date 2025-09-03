package jspboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import jspboard.constant.BoardConstant;
import jspboard.dao.AfileDao;
import jspboard.model.Afile;
import jspboard.util.ConnectionUtil;
import jspboard.util.SqlSessionUtil;

public class AfileDaoImpl implements AfileDao {
	
	@Override
	public List<Afile> selectAfile(int aid) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		List<Afile> afileList = session.selectList("jspboard.model.selectAllAfile", aid);
		SqlSessionUtil.closeSqlSession(session);
		return afileList;
	}
	
	@Override
	public Afile getAfile(int afid) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		Afile afile = session.selectOne("jspboard.model.selectOneAfile", afid);
		SqlSessionUtil.closeSqlSession(session);
		return afile;
	}
	
	@Override
	public int insertAfile(Afile afile) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int result = session.insert("jspboard.model.insertAfile", afile);
		session.commit();
		SqlSessionUtil.closeSqlSession(session);
		return result;
	}
	
	@Override
	public int updateAfile(Afile afile) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int result = session.update("jspboard.model.updateAfile", afile);
		session.commit();
		SqlSessionUtil.closeSqlSession(session);
		return result;
	}
	
	@Override
	public int deleteOneAfile(int afid) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int result = session.delete("jspboard.model.deleteOneAfile", afid);
		session.commit();
		SqlSessionUtil.closeSqlSession(session);
		return result;
	}
	
	@Override
	public int deleteAllAfile(int aid) throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		int result = session.delete("jspboard.model.deleteAllAfile", aid);
		session.commit();
		SqlSessionUtil.closeSqlSession(session);
		return result;
	}
	
	@Override
	public List<Afile> latestListAfile() throws Exception {
		SqlSession session = SqlSessionUtil.getSqlSession();
		List<Afile> afilelatestList = session.selectList("jspboard.model.selectlastlistAfile");
		SqlSessionUtil.closeSqlSession(session);
		return afilelatestList;
	}
	

}
