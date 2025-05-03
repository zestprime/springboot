package com.test.cache;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private final UserServive userServive;

	public UserController(UserServive userServive) {
		this.userServive = userServive;
	}

	@GetMapping("/user/{id}")
	public String getUser(@PathVariable String id) {
		return userServive.getUser(id);
	}

	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable String id) {
		return userServive.evictUser(id);
	}
	
}
