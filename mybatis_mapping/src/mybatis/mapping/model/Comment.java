package mybatis.mapping.model;

import java.io.Serializable;

public class Comment implements Serializable {

	public static final long serialVersionUID = 465456565656626L;

	private int id;
	private String name;
	private String text;
	private String post_id;

	public Comment() {
	}

	public Comment(int id, String name, String text, String post_id) {
		this.id = id;
		this.name = name;
		this.text = text;
		this.post_id = post_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return text;
	}

	public void setComment(String text) {
		this.text = text;
	}

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", name=" + name + ", comment=" + text + ", post_id=" + post_id + "]";
	}

}
