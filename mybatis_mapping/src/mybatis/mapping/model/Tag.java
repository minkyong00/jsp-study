package mybatis.mapping.model;

import java.io.Serializable;

public class Tag implements Serializable {

	public static final long serialVersionUID = 652633333333333L;

	private int id;
	private String name;
	private int post_id;

	public Tag() {
	}

	public Tag(int id, String name, int post_id) {
		this.id = id;
		this.name = name;
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

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", post_id=" + post_id + "]";
	}

}
