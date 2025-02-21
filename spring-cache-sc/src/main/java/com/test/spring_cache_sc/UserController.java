package com.test.spring_cache_sc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/details")
	public String getUser(@RequestParam Long id) {
		return userService.getUserById(id);
	}

	@DeleteMapping("/details")
	public String deleteUser(@RequestParam Long id) {
		userService.evictCache(id);
		return "Cache cleared for user " + id;
	}

	@PutMapping("/details")
	public String updateUser(@RequestParam Long id) {
		return userService.updateUser(id);
	}
}
