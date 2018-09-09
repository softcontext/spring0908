package com.example.demo.aopns1;

import org.springframework.stereotype.Component;

@Component
public class Second {

	public void one() {
		System.out.println("Second # one()");
	}
	
	public void one2() {
		System.out.println("Second # one2()");
	}
	
	public void two() {
		System.out.println("Second # two()");
	}
	
	public double add(int a, double b) {
		System.out.println("Second # add(int a, double b)");
		return a + b;
	}
	
	public int divide(int a, int b) {
		System.out.println("Second # divide(int a, int b)");
		return a / b;
	}
}
