package com.qa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.qa.service.business.iUserService;
import org.springframework.web.bind.annotation.PathVariable;


@RequestMapping("/user")
@RestController
public class UserController {
	
	
	private iUserService service;
	
	
	@RequestMapping("/getUsers")
	@ResponseBody
	public String getAllUsers() {
		return service.getAllUsers();
		
	}
	
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUser(String user) {
		return service.addUser(user);
	}
	
	@RequestMapping("/updateUser/{id}")
	@ResponseBody
	public String updateUser(@PathVariable("id") int id, String user) {
		return service.updateUser(id, user);
	}
	
	@RequestMapping("/deleteUser/{id}")
	@ResponseBody
	public String deleteUser(@PathVariable("id") int id) {
		return service.deleteUser(id);

	}

	
	
	public void setService(iUserService service) {
		this.service = service;
	}


}
