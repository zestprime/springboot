package com.test.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.emp.Employee;

@RestController
public class MyController {

	@Autowired
	Employee emp;

	@GetMapping("/emp")
	public String getPerEmpDetails() {
		
		return emp.empDetails();
	}
}
