package com.example.demo.ioc4;

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
		 *    변화가 많다고 판단될 때 주로 사용
		 * 2. Annotation
		 *    변화가 없다고 판단될 때 주로 사용
		 * 3. Java Config Class
		 */
		
		// 2. Annotation
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"car-config-anno.xml");
		
		OrderManager manager = (OrderManager) context
				.getBean("orderManager");
		manager.order();
	}

}











