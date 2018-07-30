package com.qa.service.business;

public interface iUserService {
	
	String getAllUsers();

	String addUser(String user);

	String updateUser(int id, String user);

	String deleteUser(int id);
	

}
