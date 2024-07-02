import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.impl.ItemDAO;
import models.Item;

public class test {
	public static void main(String[] args){
		ItemDAO a = new ItemDAO();
		ObjectMapper mapper = new ObjectMapper();
		Item result = a.findOneItemById("1719951158546465");
		try {
			mapper.writeValue(System.out, result);
		} catch (StreamWriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void process() throws JsonMappingException, JsonProcessingException {
		String jsonString = "{\"name\": \"code\"}";
		ObjectMapper mapper = new ObjectMapper();
		Item item = mapper.readValue(jsonString, Item.class);
		System.out.println("::Name::" + item.getName());
		System.out.println("::Id::" + item.getId());
	}
}
