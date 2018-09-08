package com.example.demo.ioc5;

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
	
//	public int sell(int amount, int count) {
//		
//		return 0;
//	}
//	
//	public Vehicle sell(Vehicle vehicle) {
//		
//		return null;
//	}
}

//class Vehicle {
//	int amount;
//	int count;
//}

