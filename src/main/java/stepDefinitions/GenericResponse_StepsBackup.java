//package stepDefinitions;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import cucumber.TestContext;
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Then;
//import io.restassured.response.Response;
//import pojo.responsePayload.partialUpdateResponse;
//
//public class GenericResponse_StepsBackup {
//	
//	public static Response response;
//	TestContext testcontext;
//	partialUpdateResponse resp;
//	
//	public static Map<String,String> mapStr = new HashMap<String, String>();
//	
//	@Then("the response code is {int}")
//	public void the_response_code_is(Integer statuscode) {
//		response.then().log().all();
//		assertEquals((Integer) response.getStatusCode(), statuscode);		
//
//	}
//	
//	public static String  handleValue(Object value) {
//	    if (value instanceof JSONObject) {
//	        handleJSONObject((JSONObject) value);
//	    } 
//	    else if (value instanceof JSONArray) {
//	        handleJSONArray((JSONArray) value);
//	    } 
//	    return value.toString();
//	}
//	
//	public static void handleJSONObject(JSONObject jsonObject) {
//	    jsonObject.keys().forEachRemaining(key -> {
//	        Object value = jsonObject.get(key);
//	        if(value instanceof String) {
//		           mapStr.put(key, (String) value);
//		        System.out.println("Key : "+ key + " ^^^ Value : " + value.toString());
//		    }
//	        handleValue(value);
//	    });
//	}
//	
//	
//	  public static void handleJSONArray(JSONArray jsonArray) {
//	  jsonArray.iterator(). forEachRemaining(element -> handleValue(element)); }
//	 
//	
////	public static String getJSONObjectValue(JSONObject jsonObject, String key) {
////			if(key == handleJSONObject(jsonObject)) {
////				
////			}
////		
////		return "test";
////		
////	}
//	
////	public static Object jsonSmoother(Entry e){
////		if(e.getValue() instanceof Map) { System.out.println("func newwwwww Instance Map key : " + e.getKey()+" VVVVV "+ e.getValue().toString());
////			return jsonSmoother((Entry)((Map) e.getValue()).entrySet());
////		}
////  		return e;
////	}
//	
//	
//	
////	  public static Map.Entry<?, ?> handleMap(Map<String,Object> m){ 
////		  Entry e=(Entry)
////				  m.entrySet(); if(e.getValue() instanceof Map) {
////					  System.out.println("Instance Map key : " + e.getKey()+" VVVVV "+
////							  e.getValue().toString()); jsonSmoother() } 
////				  return e; }
//	 
//	
//	@Then("response contains following values")
//	public void response_contains_following_values(DataTable dataTable) throws JsonMappingException, JsonProcessingException {
//		Map<String,String> expectedkeyvalues=dataTable.asMap(String.class, String.class);
//		System.out.println("Response for expectedkeyvalues .............*******....."+ expectedkeyvalues.size()); expectedkeyvalues.keySet().forEach(System.out::println);
//		System.out.println("Response for partial booking .............*******....." + response.asString());
//		//Map<String,String> resMap= JsonMapper.readValue(response.asString(), Map.class); 
//		ObjectMapper objectMapper = new ObjectMapper();
//		Map<String, Object> resMap = objectMapper.readValue(response.asString(), Map.class); 
//		
//		System.out.println("Testing.....Listtttttttt for partial booking .............*******....." );
//		
//		Map<String, Object> resMap2;
//		resMap.entrySet().stream()
//		      .forEach( e -> { 
//		      				
//		                if(e.getValue() instanceof Map) { System.out.println("Instance Map key : " + e.getKey()+" VVVVV "+ e.getValue().toString());}
//		    	  		else { System.out.println("Instance other than Map key : " + e.getKey()+" VVVVV "+ e.getValue().toString() + " iiiii " + e.getValue().getClass().getName());}
//		    	  			
//		    	  		
//		    		  
//		    		  
//		    		 });
//		
//		
//		
//		resMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).entrySet().stream()
//	      .forEach( e -> { 
//				
//              if(e.getValue() instanceof Map) { System.out.println("Instance Map key : " + e.getKey()+" VVVVV "+ e.getValue().toString());}
//  	  		else { System.out.println("Instance other than Map key : " + e.getKey()+" VVVVV "+ e.getValue().toString() + " iiiii " + e.getValue().getClass().getName());}
//  	  			
//  	  		
//  		  
//  		  
//  		 });
//		
//	    //.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, Map::putAll));
////		   
//		
////		for((k,v) : resMap.entrySet()) {
////			
////		}
//		
//		//List<Entry<String, Object>> l1 =resMap.entrySet().stream().filter(e -> "firstname".equals(e.getKey())).collect(Collectors.toList());
//		System.out.println("Listtttttttt for partial booking .............*******....." );
//		//l1.forEach(System.out::println);
//		//l1.forEach(e -> System.out.println("Res Map key : " + e.getKey() + "^^^^^^^^^^^" + e.getValue() ));
//		//resMap.entrySet().forEach(e -> System.out.println("Res Map key : " + e.getKey() + "^^^^^^^^^^^" + e.getValue()+ "^^^^^^^"+e.getValue().getClass().getName()));
//		
//		//if(resMap.get(""))
//		//forEach(e -> System.out.println("Res Map key : " + e.getKey() + "^^^^^^^^^^^" + e.getValue()));
//		
//		// Need to getkey in utils.getJsonPath(response,"firstname")
//		 
//		 
////		 JSONObject jso = new JSONObject(response.asString());
////		 jso.keys().forEachRemaining(key -> {
////		        Object value = jso.get(key);
////		        if(value instanceof String) {
////		           mapStr.put(key, (String) value);
////		        System.out.println("Key : "+ key + " ^^^ Value : " + value.toString());
////		        }
////		        handleValue(value);
////		    });
////		 
//		handleJSONObject(new JSONObject(response.asString()));
//		 System.out.println("Map String  *********************************");
//		 mapStr.entrySet().forEach(e -> System.out.println("K :" + e.getKey() + " ~~~~ V : " + e.getValue()));
//		 
//		for (Map.Entry<String, String> entry: expectedkeyvalues.entrySet()) {
//			if(entry.getKey().contains("&")) {
//				 String parameters[]=entry.getKey().split("&");
//				 String values[]=entry.getValue().split("&");
//				 int i=0;
////				 Bookingdates bookingdate=new Bookingdates();
//				// handleJSONObject(new JSONObject(response.asString()));
//				for(i=0;i<parameters.length;i++) {	
//					System.out.println("Parameters .............*******....." + parameters[i] + "^^^^^^^^^^^"+values[i]);
//					assertEquals(values[i],mapStr.get(parameters[i]));
//
//					
////					if(utils.getJsonPath(response,parameters[i]) instanceof String ) {
////						assertEquals(values[i],utils.getJsonPath(response,parameters[i]));
////					}
////					else  {
////						System.out.println("object printing " + utils.getJsonPath(response,parameters[i]).toString());
////					}
////				
//						
//						
//						
//					
////					 if(parameters[i].equals(("checkin"))) { 
////						 System.out.println("CheckinBooking date ***Bookingdate .............*******....." ); 					            	
////						 System.out.println("****CheckinBooking date ***Bookingdate .............*******....." + utils.getJsonPath(response,"bookingdates")); 	
////						 System.out.println("****Type CheckinBooking date ***Bookingdate .............*******....." + utils.getJsonPath(response,"bookingdates").getClass().getName() );
////						 System.out.println("$$$CheckinBooking date ***Bookingdate .............*******....." + utils.getJsonPath(response,"bookingdates.checkin")); 
////						 assertEquals(values[i],utils.getJsonPath(response,"bookingdates.checkin")); 
////						 }
////					  else if (parameters[i].equals(("checkout"))) {
////						  System.out.println("CheckoutBooking date ***Bookingdate .............*******....." ); 	
////						  System.out.println("%%%CheckoutBooking date ***Bookingdate .............*******....." + utils.getJsonPath(response,"checkout")); 	
////						  //System.out.println("CheckoutBooking date ***Bookingdate .............*******....." + resp.getBookingdates().getCheckout());
////						  assertEquals(values[i],utils.getJsonPath(response,"bookingdates.checkout"));
////					  ; }
////					 else {
////					 
////						  assertEquals(values[i],utils.getJsonPath(response,parameters[i]));
////					  }
//				}				
//				
//			}
//
//		} 
//		
//	}
//	
//
//}
