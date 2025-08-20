package jdbcmvc.command;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcmvc.model.Person;

public class UpdateProcCommand extends AbstractPerson {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
		throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		
		int pid = Integer.parseInt(req.getParameter("pid"));
		String pname = req.getParameter("pname")==null ? "" : req.getParameter("pname");
		int page = req.getParameter("page")==null ? 0 :  Integer.parseInt(req.getParameter("page"));
		
		int result = personService.updatePerson(new Person(pid, pname, page));
		List<Person> personList = personService.listPerson();
		
		req.setAttribute("personCount", personService.countPerson());
		req.setAttribute("personList", personList);
		req.setAttribute("result", result);
		
		return "/jsp/list.jsp";
	}

}
