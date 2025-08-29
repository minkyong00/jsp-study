package jspboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import jspboard.dao.AfileDao;
import jspboard.dao.impl.AfileDaoImpl;
import jspboard.dto.Thumbnail;
import jspboard.model.Afile;
import jspboard.service.AfileService;

public class AfileServiceImpl implements AfileService {

	private AfileDao afileDao;
	
	public AfileServiceImpl() {
		afileDao = new AfileDaoImpl();
	}
	
	@Override
	public List<Afile> listAfile(int aid) throws Exception {
		return afileDao.selectAfile(aid);
	}
	
	@Override
	public Afile getAfile(int afid) throws Exception {
		return afileDao.getAfile(afid);
	}
	
	@Override
	public int registAfile(Afile afile) throws Exception {
		return afileDao.insertAfile(afile);
	}
	
	@Override
	public int modifyAfile(Afile afile) throws Exception {
		return afileDao.updateAfile(afile);
	}
	
	@Override
	public int removeOneAfile(int afid) throws Exception {
		return afileDao.deleteOneAfile(afid);
	}
	
	@Override
	public int removeAllAfile(int aid) throws Exception {
		return afileDao.deleteAllAfile(aid);
	}
	
	@Override
	public List<Afile> latestListAfile() throws Exception {
		return afileDao.latestListAfile();
	}
	
}
