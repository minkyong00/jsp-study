package jspboard.command;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.model.Afile;
import jspboard.service.AfileService;
import jspboard.service.ArticleService;
import jspboard.service.impl.AfileServiceImpl;
import jspboard.service.impl.ArticleServiceImpl;

public class RemoveArticleCommand implements BoardCommand {
	
	private ArticleService articleService;
	private AfileService afileService;
	
	public RemoveArticleCommand() {
		this.articleService = new ArticleServiceImpl();
		this.afileService = new AfileServiceImpl();
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int aid = req.getParameter("aid")==null ? 0 : Integer.parseInt(req.getParameter("aid"));
		
		int result = articleService.removeArticle(aid);
		List<Afile> afileList = afileService.listAfile(aid);
		
		File deleteFile = null;
		List<File> deleteFileList = null;
		if(afileList!=null && afileList.size() > 1) {
			deleteFileList = new ArrayList<File>();
			for(Afile afile : afileList) {
				deleteFileList.add(new File(afile.getAfsfname()));
			}
		} else if(afileList.size() == 1) {
			deleteFile = new File(afileList.get(0).getAfsfname());
			deleteFile.delete();
		}

		if(deleteFileList != null) {
			for(File file : deleteFileList) {
				file.delete();
			}
		}
		
		afileService.removeAllAfile(aid);
		req.setAttribute("result", result);
		
		return "/article/listArticle.do";
	}

}
