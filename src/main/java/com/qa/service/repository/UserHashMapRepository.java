package com.qa.service.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import com.qa.userdata.UserData;
import com.qa.utility.JSONUtility;
@ApplicationScoped
@Default
public class UserHashMapRepository implements iUserRepository {

	private Map<Integer, UserData> userMap;
	private int id=1;
	
	
	@Inject
	private JSONUtility util;
	
	public void UserMapRepository() {
		this.userMap = new HashMap<Integer, UserData>();

	}

	@Override
	public String getAllUsers() {
		return util.getJSONForObject(userMap.values());
	}

	@Override
	public String createUser(String user) {
		id++;
		UserData newUser = util.getObjectForJSON(user, UserData.class);
		userMap.put(id, newUser);
		return user;
	}

	@Override
	public String updateUser(int id, String updatedUser) {
		UserData newUser = util.getObjectForJSON(updatedUser, UserData.class);
		userMap.put(id, newUser);
		return updatedUser;
	}

	@Override
	public String deleteUser(int id) {
		userMap.remove(id);
		return "{\"message\": \"accout sucessfully removed\"}";
	}


}
