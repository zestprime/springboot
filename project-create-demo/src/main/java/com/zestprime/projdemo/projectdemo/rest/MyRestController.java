package com.zestprime.projdemo.projectdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	
	@GetMapping("/")
	public String getMyName() {
		return "Zest prime";
	}

}
