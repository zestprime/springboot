
package com.test.demo;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	ChatModel chatmodel;

	@RequestMapping("/hello")
	public String hello(@RequestParam String name) {
		System.out.println("hello");
		return chatmodel.call(name);
	}
}
