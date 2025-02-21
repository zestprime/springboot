package com.test.spring_cache_sc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Cacheable(value = "users", key = "#id")
	public String getUserById(Long id) {
		logger.info("Fetching user with ID: {}", id); // DB Call simulate
		return "User Details of :" + id;
	}

	@CacheEvict(value = "users", key = "#id")
	public void evictCache(Long id) {
		logger.info("Deleting user with ID: {}", id); // DB Call simulate
	}

	@CachePut(value = "users", key = "#id")
	public String updateUser(Long id) {
		logger.info("Updating user ID: {}", id); // DB Call simulate
		return "User Details Updated :" + id;
	}
}
