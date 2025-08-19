package jdbcmvc.command;

import jdbcmvc.service.PersonService;
import jdbcmvc.service.Impl.PersonServiceImpl;

public abstract class AbstractPerson implements PersonCommand {
	
	// 모든 커맨드에 서비스가 필요하기 때문에
	// 상위 추상 클래스가 personCommand를 구현해서
	// 각 하위 커맨드에서는 추상클래스를 상속받음
	
	public PersonService personService;
	
	public AbstractPerson() {
		personService = new PersonServiceImpl();
	}

}
