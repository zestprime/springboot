package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.Customer;

@Configuration
public class MyConfiguration {

	@Bean
	public Customer getMyBean() {
		return new Customer();//manual
	}
}
