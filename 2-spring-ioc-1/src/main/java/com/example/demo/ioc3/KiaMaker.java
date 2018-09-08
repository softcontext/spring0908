package com.example.demo.ioc3;

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
