package com.test.emp;

import org.springframework.stereotype.Component;

@Component
public class ConEmployee implements Employee{
	public String empDetails() {
		return "Con -Details";
	}
}
