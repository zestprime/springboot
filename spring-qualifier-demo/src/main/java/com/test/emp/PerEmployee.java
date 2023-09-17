package com.test.emp;

import org.springframework.stereotype.Component;

@Component
public class PerEmployee implements Employee{

	public String empDetails() {
		return "Per -Details";
	}
}
