package com.example.demo.ioc5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 클래스는 빈 컨테이너 설정정보가 있음을 통보한다.
public class CarConfig {
	
//	CarMaker hyundaiMaker = new com.example.demo.ioc3.HyundaiMaker(); // 객체 생성
//	CarMaker kiaMaker = new KiaMaker(); // 객체 생성
//	
//	OrderManager manager = new OrderManager(); // 객체 생성
//	manager.setMaker(hyundaiMaker); // 의존객체 주입
	
	
	
//	<bean id="hyundaiMaker" class="com.example.demo.ioc3.HyundaiMaker"></bean>
//	<bean id="kiaMaker" class="com.example.demo.ioc3.KiaMaker"></bean>
//	
//	<bean id="manager" class="com.example.demo.ioc3.OrderManager">
//		<constructor-arg ref="kiaMaker"></constructor-arg>
//	</bean>

	// @Bean: 메소드명을 id로 삼고 메소드가 리턴하는 결과를 빈 컨테이너에 등록해라!
	@Bean
	public HyundaiMaker hyundaiMaker() {
		HyundaiMaker hyundaiMaker = new HyundaiMaker();
		return hyundaiMaker;
	}
	
	@Bean
	public KiaMaker kiaMaker() {
		KiaMaker kiaMaker = new KiaMaker();
		return kiaMaker;
	}
	
	@Bean
	public OrderManager manager() {
		OrderManager manager = new OrderManager(kiaMaker());
		
//		OrderManager manager = new OrderManager();
//		manager.setMaker(hyundaiMaker());
		
		return manager;
	}
}


