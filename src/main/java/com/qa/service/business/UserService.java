package com.qa.service.business;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.qa.service.repository.iUserRepository;
import com.qa.userdata.UserData;
import com.qa.utility.JSONUtility;

public class UserService implements iUserService {

	@Autowired
	private JSONUtility util;
	@Autowired
	private iUserRepository repo;
	
	//private static final Logger LOGGER = Logger.getLogger(UserService.class);

	public Iterable<UserData> getAllUsers() {
		return repo.findAll();
	}

	@Override
	public UserData addUser(UserData user) {
		//LOGGER.info(util.getObjectForJSON(user, UserData.class));
		//System.out.println(user);
		return repo.save(util.getObjectForJSON(user, UserData.class));
		
	}

	@Override
	public String deleteUser(int id) {
		repo.deleteById(id);
		return null;

	}

	@Override
	public List<UserData> findUser(String name) {
		return repo.findByLastName(name);

	}

	@Override
	public UserData test() {

		return repo.save(new UserData("Jack", "Bauer"));
	}

	public void setRepo(iUserRepository repo) {
		this.repo = repo;
	}

	@Override
	public UserData addUser(String user) {
		
		return repo.save(util.getObjectForJSON(user, UserData.class));
	}



}
