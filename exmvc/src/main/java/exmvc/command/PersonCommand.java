package exmvc.command;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PersonCommand {
	
	public abstract String process(HttpServletRequest req, HttpServletResponse resp)
		 throws ServerException, IOException;
	
}
