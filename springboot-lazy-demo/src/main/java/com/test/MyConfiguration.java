package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.demo.Customer;

@Configuration
@Lazy
public class MyConfiguration {

	public MyConfiguration() {
		System.out.println("MyConfiguration()--------->");
	}
	@Bean
	@Lazy
	public Customer getMyBean() {
		return new Customer();//manual
	}
}
