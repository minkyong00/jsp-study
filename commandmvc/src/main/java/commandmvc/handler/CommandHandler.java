package commandmvc.handler;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler {

	// 커맨드: 명령어, 명령어 처리 클래스를 따로 만들어둠
	// 어떤 uri 요청이 오면 처리한 결과를 보낼 view페이지의 문자열을 리턴
	public abstract String process(HttpServletRequest req, HttpServletResponse res)
		throws ServerException, IOException;
	
}
