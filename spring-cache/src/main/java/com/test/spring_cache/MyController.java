package com.test.spring_cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	private MyService service;
	
	@GetMapping("/sq")
	public int getSqure(@RequestParam  int x) {
		return service.getSq(x);
	}
}
