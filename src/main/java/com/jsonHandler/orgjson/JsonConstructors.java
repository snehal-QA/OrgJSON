package com.jsonHandler.orgjson;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonConstructors {
	
	public static void main(String[] args) {

		try {
				//JSON Put constructor using String
				JSONObject joStr = new JSONObject();
				joStr.put("name", "jon doe");
				joStr.put("age", "22");
				joStr.put("city", "chicago");
				System.out.println("joStr : " + joStr.toString());
				
				//JSON constructor using Map put
				Map<String, String> map = new HashMap<>();
				map.put("name", "jon doe");
				map.put("age", "22");
				map.put("city", "chicago");
				JSONObject joMap = new JSONObject(map);
				System.out.println("joMap : " + joMap.toString());
				
				//JSON constructor using JSON String
				JSONObject joJStr = new JSONObject(
						  "{\"city\":\"chicago\",\"name\":\"jon doe\",\"age\":\"22\"}"
						);
				System.out.println("joJStr : " + joMap.toString());
				
				//JSON constructor using POJO Serialization
				DemoBean demo = new DemoBean();
				demo.setId(2);
				demo.setName("lorem ipsum");
				demo.setActive(true);

				JSONObject jo = new JSONObject(demo);
				
				
			} 
			catch (JSONException e) {        
					e.printStackTrace();
			}
	
	}

}
