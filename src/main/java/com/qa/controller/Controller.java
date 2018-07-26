package com.qa.controller;

import javax.websocket.server.PathParam;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.qa.Application;
import com.qa.BookSearch;


//@RequestMapping("/books")
@RestController
public class Controller {
	
	
	@RequestMapping("/search/{name}")
	@ResponseBody
	public String searchBooks(@PathVariable("name") String name) throws Exception {
		return  BookSearch.search(name);
		
		
		
	}

}
