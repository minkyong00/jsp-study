package jspboard.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.dto.Page;
import jspboard.model.Article;
import jspboard.service.ArticleService;
import jspboard.service.BoardService;
import jspboard.service.impl.ArticleServiceImpl;
import jspboard.service.impl.BoardServiceImpl;

public class ListArticleCommand implements BoardCommand {
	
	private ArticleService articleService;
	private BoardService boardService;
	
	public ListArticleCommand() {
		this.articleService = new ArticleServiceImpl();
		this.boardService = new BoardServiceImpl();
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int currPageNum = req.getParameter("currPageNum")==null ? 1 
				: Integer.parseInt(req.getParameter("currPageNum"));

		// 게시판 분류
		String bid = req.getParameter("bid")==null ? "" : req.getParameter("bid");
		req.setAttribute("bid", bid);
		
		// 검색어
		String searchWord = req.getParameter("searchWord")==null ? "" : req.getParameter("searchWord");
		req.setAttribute("searchWord", searchWord);
		
		req.setAttribute("boardList", boardService.listBoard());
		
		List<Article> articleList = articleService.listArticle(bid, searchWord, currPageNum);
		req.setAttribute("articleList", articleList);
		
		if(articleList!=null) {
			req.setAttribute("articleCount", articleList.size());
		} else {
			req.setAttribute("articleCount", 0);
		}
		
		// Page
		req.setAttribute("page", 
			new Page(currPageNum, articleList==null ? 0 : articleList.size()));
		
		return "/jsp/article/listArticle.jsp";
	}

}
