package jspboard.service;

import java.util.List;

import jspboard.model.Afile;

public interface AfileService {

	public default List<Afile> listAfile(int aid) throws Exception{return null;}
	
	public default Afile getAfile(int afid) throws Exception{return null;}
	
	public default int registAfile(Afile afile) throws Exception{return 0;}
	
	public default int modifyAfile(Afile afile) throws Exception{return 0;}
	
	public default int removeOneAfile(int afid) throws Exception{return 0;}
	
	public default int removeAllAfile(int aid) throws Exception{return 0;}
	
	public default List<Afile> latestListAfile() throws Exception{return null;}
	
}
