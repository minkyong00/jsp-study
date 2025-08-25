package jspboard.constant;

public final class BoardConstant {

	// member
	public static final String MEMBER_INSERT_QUERY
		= " insert into member values(?, ?, ?, systimestamp, 'N') ";
	
	public static final String MEMBER_SELECTLIST_QUERY
		= " select * from member ";

	public static final String MEMBER_SELECTONE_QUERY
	= " select * from member where mid=? ";
	
	public static final String MEMBER_UPDATE_QUERY
		= " update member set mpass=?, mname=? where mid=? ";
	
	public static final String MEMBER_DELETE_QUERY
		= " update member set mdelyn=? where mid=? ";
	
	public static final String MEMBER_LOGIN_QUERY
		= " select * from member where mid=? and mpass=? ";
	
	public static final String MEMBER_COUNT_QUERY
		= " select count(*) form member ";
	
	// board
	public static final String BOARD_INSERT_QUERY
		= "	insert into board values(seq_board.nextval, ?, systimestamp, 'N') ";
	
	public static final String BOARD_SELECTLIST_QUERY
		= " select * from board where bdelyn='N' ";

	public static final String BOARD_SELECTONE_QUERY
		= " select * from board where bid=? and bdelyn='N' ";
	
	public static final String BOARD_UPDATE_QUERY
		= " update board set bname=? where bid=? ";
	
	public static final String BOARD_DELETE_QUERY
		= " update board set bdelyn='Y' where bid=? ";
	
	// article	
	public static final String ARTICLE_INSERT_QUERY
	= "	insert into article values(seq_article.nextval, ?, ?, systimestamp, ?, ?, 'N', 'hong1', 2) ";

	public static final String ARTICLE_SELECTLIST_QUERY
		= " select * from article where adelyn='N' ";
	
	public static final String ARTICLE_SELECTONE_QUERY
		= " select * from article where aid=? and adelyn='N' ";
	
	public static final String ARTICLE_UPDATE_QUERY
		= " update article set atitle=?, acontent=?, acount=?, afcount=? where aid=? ";
	
	public static final String ARTICLE_DELETE_QUERY
		= " update article set adelyn='Y' where aid=? ";
	
	// afile	
	public static final String AFILE_INSERT_QUERY
		= "	insert into afile values(seq_afile.nextval, ?, ?, systimestamp, 'N', ?, ?) ";

	public static final String AFILE_SELECTLIST_QUERY
		= " select * from afile where afdelyn='N' ";
	
	public static final String AFILE_SELECTONE_QUERY
		= " select * from afile where afid=? and afdelyn='N' ";
	
	public static final String AFILE_UPDATE_QUERY
		= " update afile set afsfname=?, afcfname=? where afid=? ";
	
	public static final String AFILE_DELETE_QUERY
		= " update afile set afdelyn='Y' where afid=? ";
	
	// reply	
	public static final String REPLY_INSERT_QUERY
		= "	insert into reply values(seq_reply.nextval, ?, systimestamp, 'N', ?, ?) ";

	public static final String REPLY_SELECTLIST_QUERY
		= " select * from reply where rdelyn='N' ";
	
	public static final String REPLY_SELECTONE_QUERY
		= " select * from reply where rid=? and rdelyn='N' ";
	
	public static final String REPLY_UPDATE_QUERY
		= " update reply set rcontent=? where rid=? ";
	
	public static final String REPLY_DELETE_QUERY
		= " update reply set rdelyn='Y' where rid=? ";
	
}
