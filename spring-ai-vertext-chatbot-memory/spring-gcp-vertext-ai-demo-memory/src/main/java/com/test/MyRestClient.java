package com.test;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.UserMessage;
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
	@Autowired
	ChatMemory chatMemory;
	
	@GetMapping("/user")
	@CrossOrigin(origins = "http://localhost:5173/")
	public String getAnswer(@RequestParam String query,@RequestParam String userid) {
		
		UserMessage userMessage = new UserMessage(query);
		chatMemory.add(userid, userMessage);
		
		System.out.println("Query:"+query + ",userid:"+userid);
		ChatResponse reponse= chatModel.call(new Prompt(chatMemory.get(userid)));
		chatMemory.add(userid, reponse.getResult().getOutput());
		
		return reponse.getResult().getOutput().getText();
	}

}
