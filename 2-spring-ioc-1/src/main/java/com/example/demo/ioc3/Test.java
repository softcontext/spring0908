package com.example.demo.ioc3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
//		CarMaker hyundaiMaker = new com.example.demo.ioc3.HyundaiMaker(); // 객체 생성
//		CarMaker kiaMaker = new KiaMaker(); // 객체 생성
//		
//		OrderManager manager = new OrderManager(); // 객체 생성
//		manager.setMaker(hyundaiMaker); // 의존객체 주입
//		manager.order(); // 로직 수행
		
		/*
		 * 스프링 프레임워크에게 다음 작업을 위임합니다.
		 * 1.설정파일 >> 2.객체생성 후 컨테이너로 관리 >> 3.컨테이너에 있는 객체를 DI
		 * 
		 * 설정파일 같은 요청방식 3가지
		 * 1. XML
		 * 2. Annotation
		 * 3. Java Config Class
		 */
		
		// 1. XML
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"car-config.xml");
		
		OrderManager manager = (OrderManager) context.getBean("manager");
		manager.order();
		
		OrderManager manager2 = (OrderManager) context.getBean("manager");
		
		System.out.println();
		System.out.println(manager);
		System.out.println(manager2);
		// 빈 객체를 컨테이너에 하나만 만들고 요청받을 때마다 같은 객체를 준다.
		// 전체 컨테이너 안에서 해당 자료형의 객체가 단 1개만 존재하도록 관리하는 방식을
		// scope="singleton"이라고 부른다.
		// "car-config.xml" 파일에 설정을 보세요. scope="prototype"
		System.out.println(manager == manager2); // false
	}

}















