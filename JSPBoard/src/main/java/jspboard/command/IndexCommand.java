package jspboard.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspboard.model.Article;
import jspboard.service.ArticleService;
import jspboard.service.BoardService;
import jspboard.service.MemberService;
import jspboard.service.impl.ArticleServiceImpl;
import jspboard.service.impl.BoardServiceImpl;
import jspboard.service.impl.MemberServiceImpl;

public class IndexCommand implements BoardCommand {
	
	private BoardService boardService;
	private ArticleService articleService;
	private MemberService memberService;
	
	public IndexCommand() {
		this.boardService = new BoardServiceImpl();
		this.articleService = new ArticleServiceImpl();
		this.memberService = new MemberServiceImpl();
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		req.setAttribute("boardList", boardService.listBoard());
		req.setAttribute("latestMembers", memberService.latestListMember());
		
		List<Article> articleList = articleService.listArticle("21", "a", 0);
		
		req.setAttribute("latestArticles", articleList);
		System.out.println(articleList);
		
		return "/main.jsp";
	}

}
