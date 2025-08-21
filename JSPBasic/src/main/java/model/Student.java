package model;

import java.io.Serializable;

public class Student implements Serializable {

	public static final long serialVersionUID = 154545465656565656L;

	private String name;
	private int age;
	private Score score;

	public Student() {
	}

	public Student(String name, int age, Score score) {
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score = " + score + "]";
	}

}
