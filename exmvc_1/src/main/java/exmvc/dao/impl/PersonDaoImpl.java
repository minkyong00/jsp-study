package exmvc.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import exmvc.dao.PersonDao;
import exmvc.model.Person;

public class PersonDaoImpl implements PersonDao {

	// json 파일 실제 경로
	private final String JSON_FILE_PATH
		=	"C:\\pub2504\\eclipse_jee_workspace\\exmvc\\src\\main\\java\\exmvc\\persistence\\Person.json";
	
	// json 문자열과 자바 객체 변환 GSON
	private Gson gson;
	
	public PersonDaoImpl() {
		// gson 객체 생성
		gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	@Override
	public List<Person> listPerson() {
		
		try {
			// json파일을 읽어올 문자입력스트림
			BufferedReader br 
				= new BufferedReader(new FileReader(JSON_FILE_PATH, StandardCharsets.UTF_8));
			String totalLine = ""; // 전체 json 파일의 문자열 저장
			String line = ""; // 읽어들인 한 줄 저장
			while ((line = br.readLine())!=null) { // 한 줄 읽어서
				totalLine += line; // 취합
			}
			br.close();
			// 전체 json문자열을 자바의 List로 변환해서 리턴
			return gson.fromJson(totalLine, new TypeToken<List<Person>>(){}.getType());
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	} // listPerson
	
	@Override
	public void writePerson(Person person) throws Exception {
		
		// 전체 리스트
		List<Person> personList = listPerson();
		// 리스트 없으면 새로 생성
		if (personList==null) {
			personList = new ArrayList<Person>();
		}
		// 기존 리스트에 person 추가
		personList.add(person);		
		
		// 파일객체 생성
		File jsonFile = new File(JSON_FILE_PATH);
		// 파일 있으면 삭제
		if (jsonFile.exists()) jsonFile.delete();
		
		// 파일에 출력할 문자 출력 스트림 생성
		BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile, StandardCharsets.UTF_8));
		// 리스트를 json문자열로 변환해서 파일에 쓰기
		bw.write(gson.toJson(personList));
		bw.flush();
		bw.close();
		
	} // writePerson

} // class








