package Testpractice1_maven.data;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.file.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class Datareader {
	
	public  List<HashMap<String,String>> getjsondata() throws JsonMappingException, JsonProcessingException {
	String s=null;	
		try {
		 s=	FileUtils.readFileToString(new File("C:\\Users\\91753\\Documents\\My java\\Testpractice1_maven\\src\\test\\java\\Testpractice1_maven\\data.json"),StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s);
		ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String,String>> data=	mapper.readValue(s,new TypeReference<List<HashMap<String,String>>>() {
		
	});
	return data;
		
	}

}
