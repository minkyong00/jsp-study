package jspboard.constant;

public final class BoardConstant {
	
	//page
	public static final int ARTICLE_COUNT_PER_PAGE = 10;
	public static final int PAGE_NUM_PER_BLOCK = 10;
	
	
	// File Upload Directory
	public static final String FILE_UPLOAD_DIRECTORY
		= "C:/pub2504/boardfiles/";
	
	public static final String THUMBNAIL_UPLOAD_DIRECTORY
		= "C:/pub2504/thumb/orgDir/";

	// member
	public static final String MEMBER_INSERT_QUERY
		= " insert into member values(?, ?, ?, systimestamp, 'N') ";
	
	public static final String MEMBER_SELECTLIST_QUERY
		= " select * from member order by mregdate desc ";

	public static final String MEMBER_SELECTONE_QUERY
	= " select * from member where mid=? ";
	
	public static final String MEMBER_UPDATE_QUERY
		= " update member set mpass=?, mname=? where mid=? ";
	
	public static final String MEMBER_DELETE_QUERY
		= " update member set mdelyn=? where mid=? ";
	
	public static final String MEMBER_LOGIN_QUERY
		= " select * from member where mid=? and mpass=? ";
	
	public static final String MEMBER_LASTLIST_QUERY
		= " SELECT * "
		+ " FROM ( "
		+ " 	SELECT M.*, ROWNUM RN "
		+ " 	FROM ( "
		+ " 		SELECT MID, MNAME, MREGDATE, MDELYN "
		+ " 		FROM MEMBER "
		+ " 		where MDELYN = 'N' "
		+ " 		ORDER BY MID DESC "
		+ " 	) M "
		+ " 	WHERE ROWNUM <= 10 "
		+ " ) "
		+ " WHERE RN >= 1 "
		+ " ORDER BY RN ";

		
	// board
	public static final String BOARD_INSERT_QUERY
		= "	insert into board values(seq_board.nextval, ?, systimestamp, 'N') ";
	
	public static final String BOARD_SELECTLIST_QUERY
		= " select * from board order by bregdate desc ";

	public static final String BOARD_SELECTONE_QUERY
		= " select * from board where bid=? ";
	
	public static final String BOARD_UPDATE_QUERY
		= " update board set bname=? where bid=? ";
	
	public static final String BOARD_DELETE_QUERY
		= " update board set bdelyn=? where bid=? ";
	
	
	// article	
	public static final String ARTICLE_INSERT_QUERY
	= "	insert into article values(?, ?, ?, systimestamp, 0, 0, 'N', ?, ?) ";

	public static final String ARTICLE_SELECTLIST_PREFIX_QUERY
	= 	  " SELECT * "
		+ " FROM ( "
		+ " 	SELECT BA.*, ROWNUM RN "
		+ " 	FROM ( "
		+ "		SELECT A.AID, A.ATITLE, A.ACONTENT, A.AREGDATE, A.ACOUNT, "
		+ "			A.AFCOUNT, A.ADELYN, A.MID, A.BID, B.BNAME "
		+ "		FROM BOARD B, ARTICLE A "  
		+ "		WHERE B.BID = A.BID AND A.ADELYN='N' ";  
	
	public static final String ARTICLE_SELECTLIST_SUFFIX_QUERY
	= " 		ORDER BY a.aid DESC "
		+ " 	) BA "
		+ " 	WHERE ROWNUM <= ? "
		+ " ) "
		+ " WHERE RN >= ? "
		+ " ORDER BY RN ";
	
	public static final String ARTICLE_SELECTONE_QUERY
		= " select * "
		+ " from board b, article a "
		+ " where b.bid = a.bid and a.aid=?";
	
	public static final String ARTICLE_UPDATE_QUERY
		= " update article set atitle=?, acontent=?, bid=? where aid=? ";
	
	public static final String ARTICLE_DELETE_QUERY
		= " update article set adelyn='Y' where aid=? ";
	
	public static final String ARTICLE_NEXTAID_QUERY
		= " select seq_article.nextval nextaid from article ";

	public static final String GET_TOTALARTICLECOUNT_QUERY
	= " select count(*) cnt from article where adelyn='N' ";
	
	
	// afile	
	public static final String AFILE_SELECTLIST_QUERY
		= " select * from afile where aid=? order by afid desc ";
	
	public static final String AFILE_SELECTONE_QUERY
		= " select * from afile where afid=? ";
	
	public static final String AFILE_INSERT_QUERY
	= "	insert into afile values(seq_afile.nextval, ?, ?, ?, systimestamp, 'N', ?, ?) ";

	public static final String AFILE_UPDATE_QUERY
		= " update afile set afsfname=?, afcfname=? where afid=? ";
	
	public static final String AFILE_DELETEONE_QUERY
		= " delete from afile where afid=? ";
	
	public static final String AFILE_DELETEALL_QUERY
		= " delete from afile where aid=? ";
	
	public static final String AFILE_LASTLIST_QUERY
	= " SELECT * "
	+ " FROM ( "
	+ " 	SELECT M.*, ROWNUM RN "
	+ " 	FROM ( "
	+ " 		SELECT AFID, AFSFNAME, AFCFNAME, AFCONTENTTYPE, AFREGDATE, AFDELYN, MID, AID "
	+ " 		FROM AFILE "
	+ " 		where AFDELYN = 'N' "
	+ " 		ORDER BY AFID DESC "
	+ " 	) M "
	+ " 	WHERE ROWNUM <= 10 "
	+ " ) "
	+ " WHERE RN >= 1 "
	+ " ORDER BY RN ";
	
	
	// reply	
	public static final String REPLY_SELECTLIST_QUERY
	= " select * from reply where rdelyn='N' and aid=? order by rid desc ";

	public static final String REPLY_INSERT_QUERY
	= "	insert into reply values(seq_reply.nextval, ?, systimestamp, 'N', ?, ?) ";
	
	public static final String REPLY_DELETE_QUERY
	= " update reply set rdelyn='Y' where rid=? ";

	public static final String REPLY_UPDATE_QUERY
		= " update reply set rcontent=? where rid=? ";
	
	public static final String REPLY_SELECTONE_QUERY
	= " select * from reply where rid=? and rdelyn='N' ";
	
}
