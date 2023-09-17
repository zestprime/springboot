package com.test.emp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ConEmployee implements Employee{
	public String empDetails() {
		return "Con -Details";
	}
}
