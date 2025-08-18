package commandmvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commandmvc.handler.CommandHandler;

public class MVCController extends HttpServlet {

	// 커맨드(명령어)를 키로, 명령처리클래스객체를 값으로 하는 맵
	Map<String, Object> commandMap = null;
	
	@Override
	public void init() throws ServletException {
		
		// web.xml에 설정한 commandFile이라는 파라미터의 값(command.properties파일의 경로)
		String commandFile = getInitParameter("commandFile");
		
		// .properties파일을 읽어서 저장할 Properties 맵 (키가 문자열, 값도 문자열인 맵)
		Properties prop = new Properties();
		
		// .properties파일을 읽기 위해서 클래스패스에 해당하는 실제 파일경로를 획득
		String commandFilePath = getServletContext().getRealPath(commandFile);
		
		// .properties파일의 문자들을 읽을 스트림
		FileReader fr = null;
		try {
			fr = new FileReader(commandFilePath);
			// .properties파일의 키/값을 Properties의 키/값으로 저장
			prop.load(fr);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
		// Properties의 키셋의 이터레이터를 획득
		Iterator<Object> it = prop.keySet().iterator();
		
		// 명령어와 명령어처리클래스객체 매핑할 맵
		commandMap = new HashMap<String, Object>();
		
		// 키의 수만큼 반복
		while(it.hasNext()) {
			String command = (String)it.next(); // 명령어
			// 명령어처리클래스 문자열
			String handlerClassStr = prop.getProperty(command);
			try {
				// 명령어처리클래스 문자열을 가지고 명령처리클래스를 생성
				Class handlerClass = Class.forName(handlerClassStr);
				// 명령어처리클래스의 객체를 생성
				CommandHandler handlerObj = (CommandHandler)handlerClass.newInstance();
				// 명령어와 명령어처리클래스객체를 맵에 저장
				commandMap.put(command, handlerObj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	} // init
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청 URI
		String requestURI = req.getRequestURI();
		// 명령어
		String command = null;
		// 요청 URI가 컨텍스트패스로 시작하면
		if(requestURI.indexOf(req.getContextPath()) == 0) {
			// 요청 URI에서 명령어 획득, contextPath = localhost:8888/
			command = requestURI.substring(req.getContextPath().length() + 1);
		}
		
		// 명령어에 해당하는 명령어처리클래스 획득
		CommandHandler handler = (CommandHandler)commandMap.get(command);
		
		// 뷰페이지
		String viewPage = null;
		try {
			viewPage = handler.process(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 뷰페이지가 있다면
		if(viewPage!=null){
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, resp);
		}
		
	} // processRequest
	
} // class




















