package exmvc.service;

import java.util.List;

import exmvc.model.Person;

public interface PersonService {
	// printPerson메소드(Person의 이름과 나이를 출력)
	
	public abstract List<Person> listPerson() throws Exception;

	public abstract void writePerson() throws Exception;

}
