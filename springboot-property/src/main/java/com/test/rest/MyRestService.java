package com.test.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.user.UserInfo;

@RestController
public class MyRestService {

	@Autowired
	private UserInfo userInfo;
	
	@GetMapping("/name")
	public String getName() {
		return userInfo.getFname() + " " +userInfo.getLname();
	}
}
