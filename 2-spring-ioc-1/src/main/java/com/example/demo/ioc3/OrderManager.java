package com.example.demo.ioc3;

import javax.annotation.PostConstruct;

public class OrderManager {
	private CarMaker maker;
	
	@PostConstruct
	public void init() {
		System.out.println(">> @PostConstruct 애노테이션을 메소드에 붙이면 "
				+ "OrderManager 객체가 생성된 후에 스프링 이 메소드를 호출한다.");
		// 빈 컨테이너에 등록된 후 하고 싶은 일이 있다면 사용한다.
	}

	public OrderManager() {
		
	}
	
	public OrderManager(CarMaker maker) {
		super();
		this.maker = maker;
		System.out.println(">> OrderManager(CarMaker maker) called.");
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
