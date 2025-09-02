package mybatis.mapping.model;

import java.io.Serializable;
import java.util.List;

public class Blog implements Serializable {

	public static final long serialVersionUID = 454566656266L;

	private int blog_id;
	private String title;
	private int author_id;
	private Author author;
	private List<Post> posts;

	public Blog() {
	}
	
	public Blog(Integer blog_id) {
		this.blog_id = blog_id;
	}

	public Blog(int blog_id, String title, int author_id, Author author, List<Post> posts) {
		this.blog_id = blog_id;
		this.title = title;
		this.author_id = author_id;
		this.author = author;
		this.posts = posts;
	}

	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Blog [blog_id=" + blog_id + ", title=" + title + ", author_id=" + author_id + ", author=" + author
				+ ", posts=" + posts + "]";
	}

}
