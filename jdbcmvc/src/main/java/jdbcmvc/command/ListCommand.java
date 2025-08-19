package jdbcmvc.command;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcmvc.service.PersonService;
import jdbcmvc.service.Impl.PersonServiceImpl;

public class ListCommand extends AbstractPerson {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
		throws Exception {
		
		req.setAttribute("personCount", personService.countPerson());
		req.setAttribute("personList", personService.listPerson());
		
		return "/jsp/list.jsp";
	}

}
