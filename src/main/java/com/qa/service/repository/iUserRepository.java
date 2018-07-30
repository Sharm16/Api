package com.qa.service.repository;

public interface iUserRepository {
	
	String getAllUsers();

	String createUser(String user);

	String updateUser(int id, String UserToBeUpdated);

	String deleteUser(int id);
}
