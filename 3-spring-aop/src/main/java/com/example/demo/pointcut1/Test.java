package com.example.demo.pointcut1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"pointcut-config.xml");
		
		First f = context.getBean("first", First.class);
		f.one();
		f.one2();
		f.two();
		f.add(2, 3);
		
		Second s = context.getBean("second", Second.class);
		s.one();
		s.one2();
		s.two();
		s.add(2, 3);
		s.divide(2, 3);
	}

}
