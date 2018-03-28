package org.sgooty.JSONUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JSONUtils {
	
	/**
	 * @param s, String that is json 
	 * @return null, if the string is not a json object 
	 */
	
	public static JsonObject getJsonFromString(String s){ 
		JsonParser parser = new JsonParser(); 
		JsonElement jsonElement = null; 
		
		try{ 
			jsonElement = parser.parse(s); 
		}catch(JsonSyntaxException jsonSyntaxException){
			jsonSyntaxException.printStackTrace();
		}
		catch(JsonParseException jsonParseException){ 
			jsonParseException.printStackTrace();
		}
		
		if(jsonElement != null && jsonElement.isJsonObject()){ 
			return jsonElement.getAsJsonObject(); 
		}
		return null; 	
	}
	
	/**
	 * 
	 * @param JsonString, String that is Json 
	 * @param key , Key that is key 
	 * @param value, Value - that is the value
	 * @return
	 */
	
	public static String  addKeyValueToJSONString(String JsonString, String key, String value){ 
		
		JsonObject jobj = getJsonFromString(JsonString); 
		
		if(key != null && value !=null){ 
			jobj.addProperty(key, value);
		}
		return jobj.toString(); 
	}
}
