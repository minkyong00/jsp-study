package model;

import java.io.Serializable;

public class Survey implements Serializable {

	private static final long serialVersionUID = 66263566556456662L;

	private String name; // 설문조사한 이름
	private String respectPerson; // 존경하는 인물
	private String fruits; // 좋아하는 과일

	public Survey() {
	}

	public Survey(String name, String respectPerson, String fruits) {
		this.name = name;
		this.respectPerson = respectPerson;
		this.fruits = fruits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRespectPerson() {
		return respectPerson;
	}

	public void setRespectPerson(String respectPerson) {
		this.respectPerson = respectPerson;
	}

	public String getFruits() {
		return fruits;
	}

	public void setFruits(String fruits) {
		this.fruits = fruits;
	}

	@Override
	public String toString() {
		return "Survey [name=" + name + ", respectPerson=" + respectPerson + ", fruits=" + fruits + "]";
	}

}
