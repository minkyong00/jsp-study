package jspboard.command;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jspboard.constant.BoardConstant;
import jspboard.model.Afile;
import jspboard.model.Article;
import jspboard.service.AfileService;
import jspboard.service.ArticleService;
import jspboard.service.impl.AfileServiceImpl;
import jspboard.service.impl.ArticleServiceImpl;
import jspboard.util.ThumbnailUtil;

public class RegistArticleProcCommand implements BoardCommand {

	private ArticleService articleService;
	private AfileService afileService;
	
	public RegistArticleProcCommand() {
		this.articleService = new ArticleServiceImpl();
		this.afileService = new AfileServiceImpl();
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		
		String atitle = req.getParameter("atitle")==null ? "" : req.getParameter("atitle");
		String acontent = req.getParameter("acontent")==null ? "" : req.getParameter("acontent");
		String mid = req.getParameter("mid")==null ? "" : req.getParameter("mid");
		int bid = req.getParameter("bid")==null ? 0 : Integer.parseInt(req.getParameter("bid"));
		int aid = articleService.getNextAid();
		
		articleService.registArticle(
			new Article(aid, atitle, acontent, null, 0, 0,
					null, mid, bid, null)
		);
		
		// <input type="file"로 전달되는 파일들의 컬렉션 => Part 객체 하나는 업로드되는 파일 하나
		Collection<Part> parts = req.getParts();
		String serverFileName = null;
		
		// 업로드된 파일의 수만큼 반복
		for (Part part : parts) {
			
			// Part의 헤더정보를 확인해서 파일명이 있고 파일크기가 0보다 크면
			if(part.getHeader("Content-Disposition").contains("filename=")
				&& part.getSize()>0) {

				// 컨텐트타입이 image이고 사진게시판일 경우
				// thumb/orgDir 디렉토리에 저장
				if(part.getContentType().substring(0, part.getContentType().indexOf('/')).equals("image")
						&& articleService.getArticle(aid+1).getBid() == 23) {
					serverFileName = getFileServerName(BoardConstant.THUMBNAIL_UPLOAD_DIRECTORY);
				} else {
					serverFileName = getFileServerName(BoardConstant.FILE_UPLOAD_DIRECTORY);
				}
				
				// 파일 업로드
				part.write(serverFileName);
				
				// afile 테이블에 업로드한 파일정보 등록
				afileService.registAfile(
					new Afile(
						0, serverFileName, part.getSubmittedFileName(), 
						part.getContentType(), null, null, mid, aid+1
					)
				);
				
				// 서버파일이름에 thumb 디렉토리가 포함한 경우
				if(serverFileName.contains("thumb")) {
					// 원본파일 디렉토리
					String orgDirName = serverFileName.substring(0, serverFileName.indexOf("/"));
					// 원본파일명
					String orgFileName = serverFileName.substring(serverFileName.lastIndexOf("\\")+10, serverFileName.length());
					// 원본파일 전체 경로
					String orgFilePath = orgDirName + "/" + orgFileName;
					
					// 썸네일파일 디렉토리
					String thumbDirName = "C:\\pub2504\\eclipse_jee_workspace\\MyBatisBoard\\src\\main\\webapp\\resources\\images\\";
					// 확장자 제외한 썸네일파일 경로
					String thumbFileNameOnly = thumbDirName + orgFileName;
				    
					ThumbnailUtil.createThumbnail(orgFilePath, thumbFileNameOnly + "_thumb.jpg", 200, 150);
				    
				    ThumbnailUtil.createThumbnail(orgFilePath, thumbFileNameOnly+"_thumb2.jpg", 400, 400,
				            0.9f, false, Color.WHITE);
					
				}
				
			} // Part header if
		} // for
		
		res.sendRedirect("/article/listArticle.do");
		
		return "";
	}
	
	
	private String getFileServerName(String orgDir) {
		
		// 일자별 업로드 디렉토리 생성
		File fileUploadDirectory = new File(
				orgDir + new SimpleDateFormat("yyyyMMdd")
				.format(new Date(System.currentTimeMillis())));
		if(!fileUploadDirectory.exists()) fileUploadDirectory.mkdir();
		
		// 서버에 저장될 파일명을 생성
		// UUID.randomUUID() : 36자리 임의의 문자열을 반환
		String serverFileName = fileUploadDirectory.getPath() 
				+ "/" + UUID.randomUUID();
		
		return serverFileName;
	}
	
	private String getParameterValue(String paramName, HttpServletRequest req) 
		throws Exception {
		return new BufferedReader(
				new InputStreamReader(req.getPart(paramName).getInputStream())
			).lines().collect(Collectors.joining("\n"));
	}
	
}
