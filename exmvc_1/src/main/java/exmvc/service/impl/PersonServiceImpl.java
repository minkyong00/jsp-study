package exmvc.service.impl;

import java.util.List;

import exmvc.dao.PersonDao;
import exmvc.dao.impl.PersonDaoImpl;
import exmvc.model.Person;

public class PersonServiceImpl implements exmvc.service.PersonService {
	
	private PersonDao personDao;
	
	public PersonServiceImpl() {
		personDao = new PersonDaoImpl();
	}
	
	@Override
	public List<Person> listPerson() throws Exception {
		return personDao.listPerson();
	}
	
	@Override
	public void writePerson(Person person) throws Exception {
		personDao.writePerson(person);
	}

}
