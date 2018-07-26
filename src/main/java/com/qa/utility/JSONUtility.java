package com.qa.utility;

import com.google.gson.Gson;

public class JSONUtility {
	private Gson gson;
	
	public JSONUtility() {
		this.gson= new Gson();
		
	}
	
	public String getJSONForObject(Object obj) {
		return gson.toJson(obj);
		
	}
	

}
