package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Customer;

@RestController
@Lazy
public class MyController {

	public MyController() {
		System.out.println("MyController()------->");
	}
	@Autowired
	public Customer customer;
	
	@Autowired
	public MyConponent conponent;
	
	@GetMapping
	public String getCustInfo() {
		return customer.getName();
	}
}
