package com.qa.service.business;

import java.util.List;

import com.qa.userdata.UserData;

public interface iUserService {
	
	Iterable<UserData> getAllUsers();

	UserData addUser(UserData user);

	String deleteUser(int id);

	List<UserData> findUser(String name);

	UserData test();

	UserData addUser(String user);
	

}
