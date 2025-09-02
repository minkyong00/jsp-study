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
		
		
		List<Afile> afileList = afileService.listAfile(aid);
		File deleteFile = null;
		List<File> deleteFileList = null;
		// 게시물에 해당하는 파일리스트가 null이 아니거나
		// 사이즈가 2개이상일경우
		if(afileList!=null && afileList.size() > 1) {
			// 삭제할 파일을 담는 리스트 객체 생성
			deleteFileList = new ArrayList<File>();
			// 삭제할 파일의 서버파일경로를 삭제할 파일 리스트에 담음
			for(Afile afile : afileList) {
				deleteFileList.add(new File(afile.getAfsfname()));
			}
			// 첨부파일이 1개일 경우
		} else if(afileList.size() == 1) {
			// 삭제
			new File(afileList.get(0).getAfsfname()).delete();
		}

		// 삭제할 파일리스트가 null이 아닐경우
		if(deleteFileList != null) {
			// 삭제
			for(File file : deleteFileList) {
				file.delete();
			}
		}
		
		int result = articleService.removeArticle(aid);
		req.setAttribute("result", result);
		afileService.removeAllAfile(aid);
		
		return "/article/listArticle.do";
	}

}
