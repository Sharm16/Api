package com.qa.service.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.inject.Inject;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.catalina.User;
import org.springframework.transaction.annotation.Transactional;

import com.qa.utility.*;

import net.minidev.json.JSONUtil;


@Transactional(SUPPORTS)
public class UserDBRepository implements iUserRepository {


	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllUsers() {
		Query query = manager.createQuery("Select a FROM User a");
		Collection<User> users = (Collection<User>) query.getResultList();
		return util.getJSONForObject(users);
	}

	@Override
	@Transactional(REQUIRED)
	public String createUser(String accout) {
		User anUser = util.getObjectForJSON(accout, User.class);
		manager.persist(anUser);
		return "{\"message\": \"user has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateUser(int id, String userToUpdate) {
		User updatedUser = util.getObjectForJSON(userToUpdate, User.class);
		User userFromDB = findUser(id);
		if (userToUpdate != null) {
			userFromDB = updatedUser;
			manager.merge(userFromDB);
		}
		return "{\"message\": \"user sucessfully updated\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteUser(int id) {
		User userInDB = findUser(id);
		if (userInDB != null) {
			manager.remove(userInDB);
		}
		return "{\"message\": \"user sucessfully deleted\"}";
	}

	private User findUser(int id) {
		return manager.find(User.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}

