package exmvc.service.impl;

import java.util.List;

import exmvc.dao.PersonDao;
import exmvc.dao.impl.PersonDaoImpl;
import exmvc.model.Person;
import exmvc.service.PersonService;

public class PersonServiceImpl implements PersonService{
	
	private PersonDao personDao;
	
	public PersonServiceImpl() {
		personDao = new PersonDaoImpl();
	}

	@Override
	public List<Person> listPerson() throws Exception {
		return personDao.listPerson();
		
	}

	@Override
	public void writePerson() throws Exception {
		
	}

	
	

}
