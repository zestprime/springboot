package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.bean.Application;

@RestController
public class MyController {

	//1.Property Level 
	//@Autowired
	//private Application app ;
	
	//private Application app ;
	
	//2.Constructor level
	/*@Autowired
	public MyController(Application app) {
		this.app=app;
	}*/
	
	private Application app ;
	
	//3.Setter & Get
	@Autowired
	public void setApp(Application app) {
		this.app = app;
	}



	@GetMapping("/name")
	public String getName() {
		return app.myAppName();
	}
}
