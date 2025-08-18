package exmvc.dao;

import java.util.List;

import exmvc.model.Person;

public interface PersonDao {

	public abstract List<Person> listPerson() throws Exception;

	public abstract void writePerson() throws Exception;
	
}
