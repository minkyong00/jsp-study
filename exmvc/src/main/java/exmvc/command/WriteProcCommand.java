package exmvc.command;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exmvc.model.Person;
import exmvc.service.PersonService;
import exmvc.service.impl.PersonServiceImpl;

public class WriteProcCommand implements PersonCommand {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		
		Person person = new Person(name, age);
		
		PersonService personService = new PersonServiceImpl();
		boolean result = false;
		try {
			result = personService.writePerson(person);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result) {
            req.setAttribute("msg", "저장 완료!");
        } else {
            req.setAttribute("msg", "저장 실패!");
        }
		
		return "/jsp/writeProcPerson.jsp";
	}

}
