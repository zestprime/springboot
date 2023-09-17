package com.test;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MyConponent {

	public MyConponent() {
		System.out.println("MyConponent()------------>");
	}
	public String getname() {
		return "Zest Prime";
	}
}
