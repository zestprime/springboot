package com.test.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServive {


	@Cacheable(value = "myCache", key = "#userId")
	public String getUser(String userId) {
		System.out.println("Fetching from DB...:"+userId);
		return "UserData for " + userId;
	}

	@CacheEvict(value = "myCache", key = "#userId")
	public String evictUser(String userId) {
		System.out.println("Evicted user: " + userId);
		return "delete -success:"+userId;
	}
}
