package mybatis.advanced.model;

import java.io.Serializable;
import java.util.List;

public class Blog implements Serializable {

	public static final long serialVersionUID = 656266999989898L;

	private int blogId;
	private String blogName;
	private String blogTitle;
	private Author author;
	private List<Comm> commList;
	private int blogAuthorId;

	public Blog() {
	}

	public Blog(int blogId, String blogName, String blogTitle, Author author, List<Comm> commList, int blogAuthorId) {
		this.blogId = blogId;
		this.blogName = blogName;
		this.blogTitle = blogTitle;
		this.author = author;
		this.commList = commList;
		this.blogAuthorId = blogAuthorId;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Comm> getCommList() {
		return commList;
	}

	public void setCommList(List<Comm> commList) {
		this.commList = commList;
	}

	public int getBlogAuthorId() {
		return blogAuthorId;
	}

	public void setBlogAuthorId(int blogAuthorId) {
		this.blogAuthorId = blogAuthorId;
	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", blogName=" + blogName + ", blogTitle=" + blogTitle + ", author=" + author
				+ ", commList=" + commList + ", blogAuthorId=" + blogAuthorId + "]";
	}

}
