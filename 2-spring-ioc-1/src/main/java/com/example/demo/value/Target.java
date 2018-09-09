package com.example.demo.value;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class Target {
	@Value("#{source.name}")
	private String id;
	
	private int age;
}
