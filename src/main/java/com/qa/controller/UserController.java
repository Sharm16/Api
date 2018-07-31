package com.qa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.qa.service.business.iUserService;
import com.qa.userdata.UserData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/user")
@RestController
public class UserController {
	
	@Autowired
	private iUserService service;
	
	
	@RequestMapping("/getUsers")
	@ResponseBody
	public Iterable<UserData> getAllUsers() {
		return service.getAllUsers();
		
	}
	
	@RequestMapping("/addUser")
	@ResponseBody
	public UserData addUser(@RequestBody String user) {
		return service.addUser(user);
	}
	@RequestMapping("/test")
	@ResponseBody
	public UserData test() {
		return service.test();
	}
	

	
	@RequestMapping("/deleteUser/{id}")
	@ResponseBody
	public String deleteUser(@PathVariable("id") int id) {
		return service.deleteUser(id);

	}

	@RequestMapping("/findUser/{name}")
	@ResponseBody
	public List<UserData> findUser(@PathVariable("name") String name) {
		return service.findUser(name);

	}
	
	
	public void setService(iUserService service) {
		this.service = service;
	}


}
