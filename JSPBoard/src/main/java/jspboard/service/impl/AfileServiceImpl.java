package jspboard.service.impl;

import java.util.List;

import jspboard.model.Afile;
import jspboard.service.AfileService;

public class AfileServiceImpl implements AfileService {

	@Override
	public List<Afile> listAfile() throws Exception {
		return AfileService.super.listAfile();
	}
	
	@Override
	public Afile getAfile(int afid) throws Exception {
		return AfileService.super.getAfile(afid);
	}
	
	@Override
	public int registAfile(Afile afile) throws Exception {
		return AfileService.super.registAfile(afile);
	}
	
	@Override
	public int modifyAfile(Afile afile) throws Exception {
		return AfileService.super.modifyAfile(afile);
	}
	
	@Override
	public int removeAfile(int afid) throws Exception {
		return AfileService.super.removeAfile(afid);
	}
	
}
