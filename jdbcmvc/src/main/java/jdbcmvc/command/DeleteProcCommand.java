package jdbcmvc.command;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcmvc.model.Person;

public class DeleteProcCommand extends AbstractPerson {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
		throws Exception {
		
		int pid = Integer.parseInt(req.getParameter("pid"));
		
		int result = personService.deletePerson(pid);
		
		List<Person> personList = personService.listPerson();

		req.setAttribute("personCount", personService.countPerson());
		req.setAttribute("personList", personList);
		req.setAttribute("result", result);
		
		return "/jsp/list.jsp";
	}

}
