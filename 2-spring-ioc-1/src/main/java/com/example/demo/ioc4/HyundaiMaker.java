package com.example.demo.ioc4;

import org.springframework.stereotype.Component;

// <bean id="hyundaiMaker" class="com.example.demo.ioc4.HyundaiMaker"></bean>

@Component("hyundaiMaker") // 클래스를 빈 컨테이너에 등록하라.
public class HyundaiMaker implements CarMaker {
	@Override
	public Car sell(Money money) {
		System.out.println("HyundaiMaker # sell() called.");
		
		System.out.println("HyundaiMaker # " + 
					money.getAmount() + " received.");
		
		Car car = new Car("Sonata");
		System.out.println("HyundaiMaker # " + 
					car.getName() + " created.");
		
		return car;
	}
	
}


