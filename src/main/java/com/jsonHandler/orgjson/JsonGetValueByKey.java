package com.jsonHandler.orgjson;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonGetValueByKey {
	
	public static  List<String> getValuesForGivenKey(String jsonArrayStr, String key) {
	    JSONArray jsonArray = new JSONArray(jsonArrayStr);
	    return IntStream
	    	   .range(0, jsonArray.length())
	    	   .mapToObj(index -> ((JSONObject)jsonArray.get(index)).optString(key)) //OptString gets value with key from JSON object
	    	   .collect(Collectors.toList());
	}
	
	public static void  handleValue(Object value) {
	    if (value instanceof JSONObject) {
	        handleJSONObject((JSONObject) value);
	    } else if (value instanceof JSONArray) {
	        handleJSONArray((JSONArray) value);
	    } else {
	    	System.out.println("Final Value : " + value.toString());
	    }
	}
	
	public static void handleJSONObject(JSONObject jsonObject) {
	    jsonObject.keys().forEachRemaining(key -> {
	        Object value = jsonObject.get(key);
	        System.out.println("Key : "+ key + " ^^^ Value : " + value.toString());
	        handleValue(value);
	    });
	}
	
	public static void handleJSONArray(JSONArray jsonArray) {
	    jsonArray.iterator().
	    forEachRemaining(element -> handleValue(element));
	}
	
	
	

	public static void main(String[] args) {
	String jsonString ="""
		[{
			  "batters": [
			    {
			      "type": "Regular",
			      "id": "1001"
			    },
			    {
			      "type": "Chocolate",
			      "id": "1002"
			    },
			    {
			      "type": "BlueBerry",
			      "id": "1003"
			    }
			  ],
			  "name": "Cake",
			  "cakeId": "0001"
			}]""";
		
		JSONArray jarray = new JSONArray(jsonString);
		//JSONObject jobject = new JSONObject();
		//jobject.put("jobj",jarray);
		JSONObject jobject = jarray.getJSONObject(0);
		
		System.out.println("JsonArray : ");
		System.out.println(jarray.toString());
		
		System.out.println("\n\nJsonObject : ");
		System.out.println(jobject.toString());
		
		System.out.println("\n\nFind value in jsonArray");
		getValuesForGivenKey(jsonString,"batters").stream().forEach(System.out::println);
		
		System.out.println("\n\nHandle JSON object");
		handleJSONObject(jobject);
		
		System.out.println("\n\nHandle JSON Array");
		handleJSONArray(jarray);
		
		String jsonString1="""
				{
					    "firstname": "Carry",
					    "lastname": "Trotller",
					    "totalprice": 111,
					    "depositpaid": true,
					    "bookingdates": {
					        "checkin": "2019-01-30",
					        "checkout": "2019-01-01"
					    },
					    "additionalneeds": "Breakfast"
					}
									""";
		
		JSONObject jobject1 = new JSONObject(jsonString1);
		
		jobject1.keys().forEachRemaining(System.out::println);
	
	}

}
