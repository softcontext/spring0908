package com.example.demo.ioc3;

import javax.annotation.PostConstruct;

public class HyundaiMaker implements CarMaker {
	
	public HyundaiMaker() {
		System.out.println(">> HyundaiMaker # HyundaiMaker() called.");
	}
	
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
	
	public void init() {
		System.out.println(">> HyundaiMaker # init() called.");
	}
}


