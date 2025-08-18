<%@page import="exmvc.model.Person"%>
<%@page import="java.util.List"%>
<%@page import="exmvc.service.impl.PersonServiceImpl"%>
<%@page import="exmvc.service.PersonService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	PersonService personService = new PersonServiceImpl();
	List<Person> personList = personService.listPerson();
	for(Person person : personList){
		out.print(person);
	}
%>