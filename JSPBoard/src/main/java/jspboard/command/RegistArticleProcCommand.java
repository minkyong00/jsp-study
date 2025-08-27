// javax.servlet.http.Part를 활용한 업로드

// web.xml에 <mutltipart> 설정
//		<servlet>
//	  	<servlet-name>BoardController</servlet-name>
//	  	<servlet-class>jspboard.controller.BoardController</servlet-class>
//	  	<multipart-config>
//	  	 <location>c:/pub2504/boardfiles/temp</location>
//	  	 <max-file-size>-1</max-file-size>
//	  	 <max-request-size>-1</max-request-size>
//	  	 <file-size-threshold>1024</file-size-threshold>
//	  	</multipart-config>
//	  </servlet>
//	  <servlet-mapping>
//	  	<servlet-name>BoardController</servlet-name>
//	  	<url-pattern>*.do</url-pattern>
//	  </servlet-mapping>
package jspboard.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
		
		// 업로드된 파일의 수만큼 반복
		for (Part part : parts) {
			
			// Part의 헤더정보를 확인해서 파일명이 있고 파일크기가 0보다 크면
			if(part.getHeader("Content-Disposition").contains("filename=")
				&& part.getSize()>0) {
				
				// 일자별 업로드 디렉토리 생성
				File fileUploadDirectory = new File(
					BoardConstant.FILE_UPLOAD_DIRECTORY
						+ new SimpleDateFormat("yyyyMMdd")
							.format(new Date(System.currentTimeMillis())));
				if(!fileUploadDirectory.exists()) fileUploadDirectory.mkdir();
				
				// 서버에 저장될 파일명을 생성
				// UUID.randomUUID() : 36자리 임의의 문자열을 반환
				String serverFileName = fileUploadDirectory.getPath() 
					+ "/" + UUID.randomUUID();
				
				/*
				System.out.println("컨텐트타입: " + part.getContentType());
				System.out.println("파일컴포넌트명(<input type='file' name=): " + part.getName());
				System.out.println("파일크기: " + part.getSize());
				System.out.println("클라이언트 업로드시 파일명: " + part.getSubmittedFileName());
				System.out.println("생성한 서버상 파일의 실제 경로: " + serverFileName);
				*/
				
				// 파일 업로드
				part.write(serverFileName);
				
				// afile 테이블에 업로드한 파일정보 등록
				afileService.registAfile(
					new Afile(
						0, serverFileName, part.getSubmittedFileName(), 
						part.getContentType(), null, null, mid, aid
					)
				);
				
			} // if
		} // for
		
		res.sendRedirect("/article/listArticle.do");
		
		return "";
	}
	
	private String getParameterValue(String paramName, HttpServletRequest req) 
		throws Exception {
		return new BufferedReader(
				new InputStreamReader(req.getPart(paramName).getInputStream())
			).lines().collect(Collectors.joining("\n"));
	}
	
}
