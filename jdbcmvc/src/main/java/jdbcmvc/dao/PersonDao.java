package jdbcmvc.dao;

import java.util.List;

import jdbcmvc.model.Person;

public interface PersonDao {

	public abstract List<Person> listPerson() throws Exception;
	
	public abstract int writePerson(Person person) throws Exception;
	
	public abstract int updatePerson(Person person) throws Exception;
	
	public abstract int deletePerson(int pid) throws Exception;

	public abstract Person getPerson(int pid) throws Exception;
	
	public abstract int countPerson() throws Exception;
	
}