package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/example")
@RestController
public class ExampleRestController {

	@GetMapping("/demo")
	public Object get() {
		Map<String, String> map = new HashMap<>();
		map.put("spring", "봄");
		map.put("summer", "여름");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
	    HttpEntity<Map<String, String>> entity = new HttpEntity<>(
	    		map, headers);
	   
		return entity;
	}

	@PostMapping("/demo")
	public Object post() {
		return null;
	}
}
