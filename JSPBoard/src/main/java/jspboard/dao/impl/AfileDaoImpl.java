package jspboard.dao.impl;

import java.util.List;

import jspboard.dao.AfileDao;
import jspboard.model.Afile;

public class AfileDaoImpl implements AfileDao {
	
	@Override
	public List<Afile> selectAfile() throws Exception {
		return AfileDao.super.selectAfile();
	}
	
	@Override
	public Afile selectAfile(int afid) throws Exception {
		return AfileDao.super.selectAfile(afid);
	}
	
	@Override
	public int insertAfile(Afile afile) throws Exception {
		return AfileDao.super.insertAfile(afile);
	}
	
	@Override
	public int updateAfile(Afile afile) throws Exception {
		return AfileDao.super.updateAfile(afile);
	}
	
	@Override
	public int deleteAfile(int afid) throws Exception {
		return AfileDao.super.deleteAfile(afid);
	}

}
