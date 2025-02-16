package com.test.spring_cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Cacheable("squre")
	public int getSq(int x) {
		sleep();
		return x * x;
	}

	public void sleep() {
		try {
			System.out.println("start");
			Thread.sleep(5000);
			System.out.println("end");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
