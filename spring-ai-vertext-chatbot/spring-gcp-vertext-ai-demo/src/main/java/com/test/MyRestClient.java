package com.test;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestClient {
	
	@Autowired
	ChatModel chatModel;
	
	@GetMapping("/user")
	@CrossOrigin(origins = "http://localhost:5173/")
	public String getAnswer(@RequestParam String query) {
		
		System.out.println("Query:"+query);
		ChatResponse reponse= chatModel.call(new Prompt(query));
		
		return reponse.getResult().getOutput().getText();
	}

}
