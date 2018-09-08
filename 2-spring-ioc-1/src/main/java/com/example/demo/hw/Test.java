package com.example.demo.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		Builder bigBuilder = new BigBuilder();
		Builder smallBuilder = new SmallBuilder();
		
		Client client1 = new Client();
		client1.setBuilder(bigBuilder);
		client1.order();
		
		System.out.println();
		
		Client client2 = new Client(smallBuilder);
		client2.order();
		
		// 위 코드를 xml을 작성하여 스프링에게 요청해 보세요.
		
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"builder-config.xml");
//		
//		Client client1 = (Client) context.getBean("client1");
//		client1.order();
//		
//		Client client2 = (Client) context.getBean("client2");
//		client2.order();
	}

}
