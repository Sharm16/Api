package com.qa.service.business;

import javax.inject.Inject;

import com.qa.service.repository.iUserRepository;

public class UserService implements iUserService {

	@Inject
	private iUserRepository repo;

	public String getAllUsers() {
		return repo.getAllUsers();
	}

	@Override
	public String addUser(String user) {
		return repo.createUser(user);
	}

	@Override
	public String updateUser(int id, String user) {
		return repo.updateUser(id, user);
	}

	@Override
	public String deleteUser(int  id) {
		return repo.deleteUser(id);

	}

	public void setRepo(iUserRepository repo) {
		this.repo = repo;
	}

	
	
	
}
