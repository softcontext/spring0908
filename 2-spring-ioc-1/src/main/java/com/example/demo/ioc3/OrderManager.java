package com.example.demo.ioc3;

public class OrderManager {
	private CarMaker maker;

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
