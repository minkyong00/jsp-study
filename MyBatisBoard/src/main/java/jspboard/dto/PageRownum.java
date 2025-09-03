package jspboard.dto;

import java.io.Serializable;

public class PageRownum implements Serializable {

	public static final long serialVersionUID = 6565311116356L;

	private String bid;
	private String searchWord;
	private int currPageNum;
	private int startRownum;
	private int endRownum;

	public PageRownum() {
	}

	public PageRownum(String bid, String searchWord, int currPageNum, int startRownum, int endRownum) {
		this.bid = bid;
		this.searchWord = searchWord;
		this.currPageNum = currPageNum;
		this.startRownum = startRownum;
		this.endRownum = endRownum;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public int getCurrPageNum() {
		return currPageNum;
	}

	public void setCurrPageNum(int currPageNum) {
		this.currPageNum = currPageNum;
	}

	public int getStartRownum() {
		return startRownum;
	}

	public void setStartRownum(int startRownum) {
		this.startRownum = startRownum;
	}

	public int getEndRownum() {
		return endRownum;
	}

	public void setEndRownum(int endRownum) {
		this.endRownum = endRownum;
	}

	@Override
	public String toString() {
		return "PageRownum [bid=" + bid + ", searchWord=" + searchWord + ", currPageNum=" + currPageNum
				+ ", startRownum=" + startRownum + ", endRownum=" + endRownum + "]";
	}

}
