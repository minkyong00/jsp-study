package exmvc.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import exmvc.dao.PersonDao;
import exmvc.model.Person;

public class PersonDaoImpl implements PersonDao {

	@Override
	public List<Person> listPerson() throws Exception {

		File file = new File(
				"C:\\pub2504\\eclipse_jee_workspace\\exmvc\\src\\main\\java\\exmvc\\persistence\\Person.json");
		FileReader fe = null;
		Gson gson = null;
		List<Person> personList = null;
		try {
			fe = new FileReader(file);
			gson = new GsonBuilder().setPrettyPrinting().create();

			JsonArray jsonArr = JsonParser.parseReader(fe).getAsJsonObject().get("person").getAsJsonArray();

			personList = new ArrayList<Person>();

			for (JsonElement ele : jsonArr) {
				String name = ele.getAsJsonObject().get("name").getAsString();
				String age = ele.getAsJsonObject().get("age").getAsString();

				Person person = new Person(name, age);
				personList.add(person);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fe.close();
		}

		return personList;

	}

	@Override
	public boolean writePerson(Person person) {
		
//		Gson gson = null;
//		try {
//			
//			List<Person> personList = listPerson();
//			if(personList == null) {
//				personList = new ArrayList<Person>();
//			}
//			personList.add(person);
//			
//			File file = new File("C:\\\\pub2504\\\\eclipse_jee_workspace\\\\exmvc\\\\src\\\\main\\\\java\\\\exmvc\\\\persistence\\\\Person.json");
//			if(file.exists()) {
//				file.delete();
//			}
//			
//			gson = new GsonBuilder().setPrettyPrinting().create();
//			
//			BufferedWriter bw = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8));
//			bw.write(gson.toJson(personList));
//			bw.flush();
//			bw.close();
//			
//			return true;
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
		
	    File file = new File("C:\\pub2504\\eclipse_jee_workspace\\exmvc\\src\\main\\java\\exmvc\\persistence\\Person.json");
	    FileReader fr = null;

	    try {
	        
	        fr = new FileReader(file);
	        JsonObject jsonObj;
	        JsonArray jsonArr;

	        try {
	            jsonObj = JsonParser.parseReader(fr).getAsJsonObject();
	        } catch(Exception e) { 
	        	e.printStackTrace();
	        	// 파일 없으면 새로운 jsonObject 생성
	            jsonObj = new JsonObject();
	        } finally {
	            fr.close();
	        }

	        if(!jsonObj.has("person")) { // person이라는 jsonObj가 없으면
	            jsonArr = new JsonArray(); // 새로운 jsonArr를 만들어서
	            jsonObj.add("person", jsonArr); // person안에 새로 만든 jsonArr 추가
	        } else {
	            jsonArr = jsonObj.getAsJsonArray("person"); // person jsonObj에서 jsonArr가져옴
	        }

	        JsonObject newPerson = new JsonObject();
	        newPerson.addProperty("name", person.getName());
	        newPerson.addProperty("age", person.getAge());
	        jsonArr.add(newPerson);

	        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        FileWriter fw = new FileWriter(file);
	        fw.write(gson.toJson(jsonObj));
	        fw.close();

	        return true;

	    } catch(Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	} // writePerson


}
