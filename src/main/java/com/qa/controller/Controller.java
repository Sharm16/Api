package com.qa.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.BookSearch;


//@RequestMapping("/books")
@RestController
public class Controller {
	
	
	@RequestMapping("/search/{name}")
	@ResponseBody
	public String searchBooks(@PathVariable("name") String name) throws Exception{
		return  BookSearch.search(name);
		
		
		
	}

}
