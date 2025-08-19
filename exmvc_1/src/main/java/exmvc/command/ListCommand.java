package exmvc.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exmvc.service.PersonService;
import exmvc.service.impl.PersonServiceImpl;

public class ListCommand implements PersonCommand {
	
	public String process(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		PersonService personService = new PersonServiceImpl();
		
		try {
			req.setAttribute("personList", personService.listPerson());
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
		
		return "/jsp/list.jsp";
	}

}
