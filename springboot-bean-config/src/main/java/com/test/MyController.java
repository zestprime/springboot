package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Customer;

@RestController
public class MyController {

	@Autowired
	public Customer customer;
	
	@GetMapping
	public String getCustInfo() {
		return customer.getName();
	}
}
