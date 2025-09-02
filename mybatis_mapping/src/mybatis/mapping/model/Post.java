package mybatis.mapping.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Post implements Serializable {

	public static final long serialVersionUID = 5653325446565L;

	private int id;
	private int blog_id;
	private int author_id;
	private String subject;
	private Timestamp created_on;
	private String section;
	private String body;
	private int draft;
	private Author author;
	private List<Comment> comments;
	private List<Tag> tags;

	public Post() {
	}

	public Post(int id, int blog_id, int author_id, String subject, Timestamp created_on, String section, String body,
			int draft, Author author, List<Comment> comments, List<Tag> tags) {
		this.id = id;
		this.blog_id = blog_id;
		this.author_id = author_id;
		this.subject = subject;
		this.created_on = created_on;
		this.section = section;
		this.body = body;
		this.draft = draft;
		this.author = author;
		this.comments = comments;
		this.tags = tags;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Timestamp getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getDraft() {
		return draft;
	}

	public void setDraft(int draft) {
		this.draft = draft;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", blog_id=" + blog_id + ", author_id=" + author_id + ", subject=" + subject
				+ ", created_on=" + created_on + ", section=" + section + ", body=" + body + ", draft=" + draft
				+ ", comments=" + comments + ", tags=" + tags + "]";
	}

}
