package exmvc.dao.impl;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
				"C:/data/Person.json");
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
	    File file = new File("C:/data/Person.json");
	    FileReader fr = null;
	    System.out.println(file);

	    try {
	        file.getParentFile().mkdirs();
	        if(!file.exists()) file.createNewFile();

	        fr = new FileReader(file);
	        System.out.println(fr);
	        JsonObject jsonObj;
	        JsonArray jsonArr;

	        try {
	            jsonObj = JsonParser.parseReader(fr).getAsJsonObject();
	        } catch(Exception e) {
	            jsonObj = new JsonObject();
	        } finally {
	            fr.close();
	        }

	        if(!jsonObj.has("person")) {
	            jsonArr = new JsonArray();
	            jsonObj.add("person", jsonArr);
	        } else {
	            jsonArr = jsonObj.getAsJsonArray("person");
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
	}


}
