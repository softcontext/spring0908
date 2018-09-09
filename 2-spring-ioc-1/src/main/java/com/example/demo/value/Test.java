package com.example.demo.value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"value-config.xml");
		
		Source s = context.getBean("source", Source.class);
		System.out.println(s);
		System.out.println();
		
		Target t = context.getBean("target", Target.class);
		System.out.println(t);
		
		Config c = context.getBean("config", Config.class);
		System.out.println(c);
	}
}
