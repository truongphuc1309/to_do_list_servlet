package utils.impl;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import utils.IReaderUtil;

public class ReaderUtil implements IReaderUtil{

	@Override
	public String toJsonString(BufferedReader reader) throws IOException {
		StringBuilder sb = new StringBuilder();
	    try {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line).append('\n');
	        }
	    } finally {
	        reader.close();
	    }
		return sb.toString();
	}

	@Override
	public <T> T reflectObject(BufferedReader reader, Class<T> model) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		T result = null;
		try {
			json = toJsonString(reader);
			result = (T) mapper.readValue(json, model);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
