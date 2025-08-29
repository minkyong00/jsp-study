package jspboard.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.dto.Thumbnail;
import jspboard.model.Afile;
import jspboard.model.Article;
import jspboard.service.AfileService;
import jspboard.service.ArticleService;
import jspboard.service.BoardService;
import jspboard.service.MemberService;
import jspboard.service.impl.AfileServiceImpl;
import jspboard.service.impl.ArticleServiceImpl;
import jspboard.service.impl.BoardServiceImpl;
import jspboard.service.impl.MemberServiceImpl;

public class IndexCommand implements BoardCommand {
	
	private BoardService boardService;
	private ArticleService articleService;
	private MemberService memberService;
	private AfileService afileService;
	
	public IndexCommand() {
		this.boardService = new BoardServiceImpl();
		this.articleService = new ArticleServiceImpl();
		this.memberService = new MemberServiceImpl();
		this.afileService = new AfileServiceImpl();
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int currPageNum = req.getParameter("currPageNum")==null ? 1 
				: Integer.parseInt(req.getParameter("currPageNum"));
		
		req.setAttribute("boardList", boardService.listBoard());
		req.setAttribute("latestMembers", memberService.latestListMember());
		req.setAttribute("latestArticles", articleService.latestListArticle());
		req.setAttribute("currPageNum", currPageNum);
		
		List<Afile> afileList = afileService.latestListAfile();
		List<Thumbnail> thumbnailList = new ArrayList<Thumbnail>();
		
		for(Afile afile : afileList) {
			
			String thumbnailFilePath = afile.getAfsfname();
			String thumbnailFileName 
				= thumbnailFilePath.substring(thumbnailFilePath.indexOf("/")+1, thumbnailFilePath.length());
			
			Thumbnail thumbnail = new Thumbnail(
				afile.getAid(),
				"/resources/images/" + thumbnailFileName + "_thumb2.jpg", 
				thumbnailFileName
			);
			
			thumbnailList.add(thumbnail);
		}
		
		req.setAttribute("latestPhotos", thumbnailList);
 
		return "/main.jsp";
	}

}
