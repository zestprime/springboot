package com.test.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Value("${env}")
	String env;

	@Value("${name}")
	String name;
	
	@GetMapping("/name")
	public String getName() {
		return name+":"+env;
	}
}
