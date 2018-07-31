package com.qa.utility;

import com.google.gson.Gson;
import com.qa.userdata.UserData;

public class JSONUtility {
	private Gson gson;
	
	public JSONUtility() {
		this.gson= new Gson();
		
	}
	
	public String getJSONForObject(Object obj) {
		return gson.toJson(obj);
		
	}
	public <T> String getObjectForJSON(UserData user, Class<UserData> class1) {
		return gson.toJson(user, class1);
	}

	public String getObjectForJSON(String user, Class<UserData> class1) {

		return gson.toJson(user, class1);
	}

}
