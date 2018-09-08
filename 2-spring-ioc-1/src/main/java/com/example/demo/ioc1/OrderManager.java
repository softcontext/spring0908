package com.example.demo.ioc1;

// OrderManager use HyundaiMaker.
// OrderManager has HyundaiMaker. Has-A Relation
// OrderManager depend HyundaiMaker. Dependency(의존) Injection(주입)

public class OrderManager {
	private HyundaiMaker maker;
	
	public OrderManager() {
		this.maker = new HyundaiMaker();
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
}
