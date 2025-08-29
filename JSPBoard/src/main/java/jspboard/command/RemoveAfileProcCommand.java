package jspboard.command;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.service.AfileService;
import jspboard.service.impl.AfileServiceImpl;

public class RemoveAfileProcCommand implements BoardCommand {
	
	private AfileService afileService;
	
	public RemoveAfileProcCommand() {
		this.afileService = new AfileServiceImpl();
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int afid = req.getParameter("afid")==null ? 0 : Integer.parseInt(req.getParameter("afid"));
		int aid = req.getParameter("aid")==null ? 0 : Integer.parseInt(req.getParameter("aid"));
		
		File deleteFile = new File(afileService.getAfile(afid).getAfsfname());
		if(deleteFile.exists()) {
			deleteFile.delete();
		}
		
		afileService.removeOneAfile(afid);
		res.sendRedirect("/article/modifyArticle.do?aid=" + aid);
		
		return "";
	}

}
