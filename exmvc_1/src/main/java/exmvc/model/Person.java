package exmvc.model;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 3429874932748923L;

	private String name;
	private String age;

	public Person() {
	}

	public Person(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
