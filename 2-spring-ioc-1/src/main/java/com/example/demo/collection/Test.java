package com.example.demo.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"collect-config.xml");
		
		Value value = context.getBean("value", Value.class);
		
		System.out.println(value.getList());
		System.out.println(value.getMap());
		System.out.println(value.getProps());
		System.out.println(value.getSet());
	}
}
