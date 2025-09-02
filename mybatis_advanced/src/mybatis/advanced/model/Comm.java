package mybatis.advanced.model;

import java.io.Serializable;

public class Comm implements Serializable {

	public static final long serialVersionUID = 6666666556565L;

	private int commId;
	private String commTitle;
	private String commContent;
	private int blogId;

	public Comm() {
	}

	public Comm(int commId, String commTitle, String commContent, int blogId) {
		this.commId = commId;
		this.commTitle = commTitle;
		this.commContent = commContent;
		this.blogId = blogId;
	}

	public int getCommId() {
		return commId;
	}

	public void setCommId(int commId) {
		this.commId = commId;
	}

	public String getCommTitle() {
		return commTitle;
	}

	public void setCommTitle(String commTitle) {
		this.commTitle = commTitle;
	}

	public String getCommContent() {
		return commContent;
	}

	public void setCommContent(String commContent) {
		this.commContent = commContent;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	@Override
	public String toString() {
		return "Comm [commId=" + commId + ", commTitle=" + commTitle + ", commContent=" + commContent + ", blogId="
				+ blogId + "]";
	}

}
