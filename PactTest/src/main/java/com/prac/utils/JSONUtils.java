package com.prac.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {
	
	public static HashMap<String, String> readSimpleJSONTOMAP(String JSON) {
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> jsonMap = new HashMap<String, String>();
		
		// convert JSON string to Map
        try {
			jsonMap = mapper.readValue(JSON,
			        new TypeReference<Map<String, String>>(){});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonMap;
		
	}

}
