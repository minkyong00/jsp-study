package exmvc.service;

import java.util.List;

import exmvc.model.Person;

public interface PersonService {
	
	public abstract List<Person> listPerson() throws Exception;
	
	public abstract void writePerson(Person person) throws Exception;

}
