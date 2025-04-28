package com.test.rag.db;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class StudentCourseController {

	private final StudentCourseResource studentCourseResource;

	public StudentCourseController(StudentCourseResource studentCourseResource) {
		this.studentCourseResource = studentCourseResource;
	}

	@GetMapping("/ask")
	public ResponseEntity<String> askQuestion(@RequestParam String question) {
		System.out.println("Question:"+question);
		String htmlResponse = studentCourseResource.processQuestion(question);
		return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(htmlResponse);
	}
}