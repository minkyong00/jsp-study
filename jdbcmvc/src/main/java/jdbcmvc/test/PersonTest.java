package jdbcmvc.test;

import jdbcmvc.model.Person;
import jdbcmvc.service.PersonService;
import jdbcmvc.service.Impl.PersonServiceImpl;

public class PersonTest {
	
	public static void main(String[] args) {
		
		PersonService personService = new PersonServiceImpl();
		
		try {
			
			// writePerson
//			 int result = personService.writePerson(new Person(0, "홍길동", 20));
//			 System.out.println(result>0 ? "등록 성공!" : "등록 실패!");
			
			// listPerson
			// System.out.println(personService.listPerson());
			
			// getPerson
			// System.out.println(personService.getPerson(2));
			
			// updatePerson
			// int result = personService.updatePerson(new Person(2, "이순신", 50));
			// System.out.println(result>0 ? "수정 성공!" : "수정 실패!");
			
			// deletePerson
			// int result = personService.deletePerson(1);
			// System.out.println(result > 0 ? "삭제 성공!" : "삭제 실패!");
			
			// countPerson
			// int personCount = personService.countPerson();
			// System.out.println("등록된 Person 수 : " + personCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
