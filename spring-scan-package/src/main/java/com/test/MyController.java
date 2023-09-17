package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.util.CousreNames;

@RestController
public class MyController {

	@Autowired
	public CousreNames cousreNames;
	
	
	@GetMapping("/")
	public String getCouseName() {
		return cousreNames.getCouseName();
	}
}
