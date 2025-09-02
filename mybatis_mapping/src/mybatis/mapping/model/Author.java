package mybatis.mapping.model;

import java.io.Serializable;

public class Author implements Serializable {

	public static final long serialVersionUID = 6662622323232L;

	private int id;
	private String username;
	private String password;
	private String email;
	private String bio;
	private String favourite_section;

	public Author() {
	}

	public Author(int id, String username, String password, String email, String bio, String favourite_section) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.bio = bio;
		this.favourite_section = favourite_section;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getFavourite_section() {
		return favourite_section;
	}

	public void setFavourite_section(String favourite_section) {
		this.favourite_section = favourite_section;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", bio="
				+ bio + ", favourite_section=" + favourite_section + "]";
	}

}
