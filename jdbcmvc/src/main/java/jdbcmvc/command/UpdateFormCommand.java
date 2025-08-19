package jdbcmvc.command;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcmvc.model.Person;

public class UpdateFormCommand extends AbstractPerson {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
		throws Exception {
		
		Person person = personService.getPerson(Integer.parseInt(req.getParameter("pid")));
		req.setAttribute("person", person);
		
		return "/jsp/updateForm.jsp";
	}

}
