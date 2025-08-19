package jdbcmvc.command;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcmvc.model.Person;

public class WriteProcCommand extends AbstractPerson {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
		throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		
		String pname = req.getParameter("pname")==null ? "" : req.getParameter("pname");
		String page = req.getParameter("page")==null ? "" :  req.getParameter("page");
		
		int result = personService.writePerson(new Person(0, pname, Integer.parseInt(page)));
		
		List<Person> personList = personService.listPerson();
		
		req.setAttribute("personCount", personService.countPerson());
		req.setAttribute("personList", personList);
		req.setAttribute("result", result);
		
		return "/jsp/list.jsp";
	}

}
