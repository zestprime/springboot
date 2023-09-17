package com.test.temp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	Map<Integer, String> map = null;

	public TestController() {
		map = new HashMap<Integer, String>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(null, "NA");
	}

	@GetMapping("/test1/{id}")
	public String pathParamTest(@PathVariable(required = false) Integer id) {
		System.out.println(map.get(id).toString());
		return map.get(id).toString();
	}

	@GetMapping("/test2")
	public String queryParamTest(@RequestParam Integer id) {
		System.out.println(map.get(id).toString());
		return map.get(id).toString();
	}
	
	
	@GetMapping("/test3")
	public String queryParamTest(@RequestParam Integer[] ids) {
		return Arrays.toString(ids);
	}
	
	@GetMapping("/test4/{ids}")
	public String pathParamTest(@PathVariable Integer[] ids) {
		return Arrays.toString(ids);
	}
}