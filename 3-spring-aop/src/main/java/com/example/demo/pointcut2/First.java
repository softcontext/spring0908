package com.example.demo.pointcut2;

import org.springframework.stereotype.Component;

@Component
public class First {
	public void one() {
		System.out.println("First # one()");
	}
	@AdviceRequired
	public void one2() {
		System.out.println("First # one2()");
	}
	
	public void two() {
		System.out.println("First # two()");
	}
	@AdviceRequired
	public double add(int a, double b) {
		System.out.println("First # add(int a, double b)");
		return a + b;
	}
}
