package com.example.demo.ioc4;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// 애노테이션은 상속(확장)으로 자식 애노테이션을 사용하면 부모 애노테이션처럼 작동한다.
// @Component 의 역할 : 객체가 빈 컨테이너에 등록된다.
// @Component 대신 @Service 애노테이션을 사용하는 이유는 
// 빈 컨테이너에 단순히 넣기만 하는게 아니라 넣은면서 해당 객체의 역할을 구분짓기 위한 시도입니다.
@Service // 비즈니스 로직을 제공하는 클래스들을 구분짓기 위해서 사용합니다.
public class OrderManager {
	// 컨테이너에 존재하는 객체들 중에서 id가 "kiaMaker" 인 객체를 찾아서
	// 변수에 직접 할당해 달라는 요청이다.
	// 애노테이션은 setter 메소드를 사용하지 않고도 직접 변수에 할당할 수 있다.
	@Resource(name="kiaMaker")
	private CarMaker maker;

	public OrderManager() {
		
	}
	
	public OrderManager(CarMaker maker) {
		super();
		this.maker = maker;
	}

	public void order() {
		System.out.println("OrderManager # order() called.");
		
		Money money = new Money(1000);
		System.out.println("OrderManager # " + 
				money.getAmount() + " created.");
		
		Car car = maker.sell(money);
		System.out.println("OrderManager # " + 
				car.getName() + " bought.");
	}

	public CarMaker getMaker() {
		return maker;
	}

	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}
	
}
