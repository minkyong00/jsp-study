package jspboard.dao;

import java.util.List;

import jspboard.model.Afile;

public interface AfileDao {

	public default List<Afile> selectAfile() throws Exception{return null;};
	
	public default Afile selectAfile(int afid) throws Exception{return null;};
	
	public default int insertAfile(Afile afile) throws Exception{return 0;};
	
	public default int updateAfile(Afile afile) throws Exception{return 0;};
	
	public default int deleteAfile(int afid) throws Exception{return 0;};
	
}
