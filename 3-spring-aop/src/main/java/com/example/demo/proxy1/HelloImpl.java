package com.example.demo.proxy1;

public class HelloImpl implements Hello {

	@Override
	public void say() {
		// 항상 작동해야 로직: Core Concern
		System.out.println("안녕하세요!");
	}

}
