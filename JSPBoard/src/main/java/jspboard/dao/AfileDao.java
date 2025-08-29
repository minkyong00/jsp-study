package jspboard.dao;

import java.util.List;

import jspboard.dto.Thumbnail;
import jspboard.model.Afile;

public interface AfileDao {

	public default List<Afile> selectAfile(int aid) throws Exception{return null;}
	
	public default Afile getAfile(int afid) throws Exception{return null;}
	
	public default int insertAfile(Afile afile) throws Exception{return 0;}
	
	public default int updateAfile(Afile afile) throws Exception{return 0;}
	
	public default int deleteOneAfile(int afid) throws Exception{return 0;}

	public default int deleteAllAfile(int aid) throws Exception{return 0;}
	
	public default List<Afile> latestListAfile() throws Exception{return null;}
	
}
