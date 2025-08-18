package exmvc.dao.impl;

import java.io.File;
import java.io.FileReader;
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
		
		File file = new File("C:\\pub2504\\eclipse_jee_workspace\\exmvc\\src\\main\\java\\exmvc\\persistence\\Person.json");
		FileReader fe = null;
		Gson gson = null;
		List<Person> personList = null;
		try {
			fe = new FileReader(file);
			gson = new GsonBuilder().setPrettyPrinting().create();
			
			JsonArray jsonArr = JsonParser.parseReader(fe).getAsJsonObject().get("person").getAsJsonArray();
			
			personList = new ArrayList<Person>();
			
			for(JsonElement ele : jsonArr) {
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
	public void writePerson() throws Exception {
		
	}
	
}
