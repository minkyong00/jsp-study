package exmvc.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exmvc.model.Person;
import exmvc.service.PersonService;
import exmvc.service.impl.PersonServiceImpl;

public class WriteProcCommand implements PersonCommand {
	
	public String process(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		// 파라미터 데이터 인코딩
		req.setCharacterEncoding("UTF-8");
		
		// 폼에서 보낸 파라미터 값 저장
		String name = req.getParameter("name")==null ? "" : req.getParameter("name");
		String age = req.getParameter("age")==null ? "" : req.getParameter("age");
		
		// 서비스구현객체 생성
		PersonService personService = new PersonServiceImpl();
		
		try {
			
			// name과 age를 가진 Person객체를 생성해서 writePerson 호출
			personService.writePerson(new Person(name, age));
			
			// personService의 listPerson메소드를 호출해서 리스트 획득하고
			// 뷰에 보낼 request 속성변수에 저장
			req.setAttribute("personList", personService.listPerson());
	
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		// 등록 완료 후 목록페이지로 이동하기 위해 목록 뷰 경로를 리턴
		return "/jsp/list.jsp";
	}

}
