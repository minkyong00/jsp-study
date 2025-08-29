package jspboard.dto;

import java.io.Serializable;

public class Thumbnail implements Serializable {

	public static final long serialVersionUID = 45554566666L;

	private int aid; // 게시물 아이디
	private String imgUrl; // 사진 url
	private String title; // 사진 제목(alt에 들어감)

	public Thumbnail() {
	}

	public Thumbnail(int aid, String imgUrl, String title) {
		this.aid = aid;
		this.imgUrl = imgUrl;
		this.title = title;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Thumbnail [aid=" + aid + ", imgUrl=" + imgUrl + ", title=" + title + "]";
	}

}
