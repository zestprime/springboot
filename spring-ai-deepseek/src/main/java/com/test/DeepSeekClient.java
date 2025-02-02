package com.test;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeepSeekClient {

	@Autowired
	ChatModel chatModel;
	
	@GetMapping("/data")
	public String getDeedSeekResponse(@RequestParam String message) {
		
		ChatResponse response = chatModel.call(
			    new Prompt(
			    		message,
			        OllamaOptions.builder()
			            .model("deepseek-r1:7b")
			            .temperature(0.4)
			            .build()
			    ));
		
		return response.getResult().getOutput().getText();
	}
}
