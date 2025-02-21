package com.test.spring_cache_sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCacheScApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheScApplication.class, args);
	}

}
