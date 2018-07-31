package com.qa.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.qa.userdata.UserData;

public interface iUserRepository extends CrudRepository<UserData, Integer>{
	
	
	List<UserData> findByLastName(String lastName);
	
	UserData save(String user);

	
//	String getAllUsers();
//
//	String createUser(String user);
//
//	String updateUser(int id, String UserToBeUpdated);
//
//	String deleteUser(int id);
}
