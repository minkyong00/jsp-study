package jspboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspboard.model.Member;
import jspboard.service.ArticleService;
import jspboard.service.BoardService;
import jspboard.service.MemberService;
import jspboard.service.impl.ArticleServiceImpl;
import jspboard.service.impl.BoardServiceImpl;
import jspboard.service.impl.MemberServiceImpl;

public class LoginProcCommand implements BoardCommand{

	private MemberService memberService;
	private ArticleService articleService;
	private BoardService boardService;
	
	public LoginProcCommand() {
		this.memberService = new MemberServiceImpl();
		this.boardService = new BoardServiceImpl();
		this.articleService = new ArticleServiceImpl();
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// 로그인 처리
		String mid = req.getParameter("mid")==null ? "" : req.getParameter("mid");
		String mpass = req.getParameter("mpass")==null ? "" : req.getParameter("mpass");
		int currPageNum = req.getParameter("currPageNum")==null ? 1 
				: Integer.parseInt(req.getParameter("currPageNum"));
		
		Member loginMember = memberService.loginMember(
			new Member(mid, mpass, null, null, null)
		);

		//세션 처리
		if(loginMember!=null) {
			req.getSession().setAttribute("loginMember", loginMember);
		}
		
		req.setAttribute("boardList", boardService.listBoard());
		req.setAttribute("latestArticles", articleService.latestListArticle());
		req.setAttribute("latestMembers", memberService.latestListMember());
		req.setAttribute("currPageNum", currPageNum);
		
		return "/main.jsp";
	}

}
