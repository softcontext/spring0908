package com.example.demo.proxy3;

// Target Object: Core Concern 로직을 제공하는 객체
public class HelloImpl implements Hello {

	@Override
	public void say() {
		// 항상 작동해야 로직: Core Concern
		System.out.println("안녕하세요!");
	}

}
