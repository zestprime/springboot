package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@GetMapping("/testport")
	public String getMyName() {
		return "Zest Prime Port Test";
	}
}
