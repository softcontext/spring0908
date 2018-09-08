package com.example.demo.ioc4;

import org.springframework.stereotype.Component;

// 객체가 빈 컨테이너에 등록된다.
@Component // id를 생략하면 클래스명을 id로 사용한다. 단, id는 소문자로 시작하는게 관습이다.
public class KiaMaker implements CarMaker {
	@Override
	public Car sell(Money money) {
		System.out.println("KiaMaker # sell() called.");
		
		System.out.println("KiaMaker # " + 
					money.getAmount() + " received.");
		
		Car car = new Car("Bongo");
		System.out.println("KiaMaker # " + 
					car.getName() + " created.");
		
		return car;
	}
	
}
