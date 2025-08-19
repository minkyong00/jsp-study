package exmvc.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PersonCommand {
	
	public abstract String process(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException; 

}
