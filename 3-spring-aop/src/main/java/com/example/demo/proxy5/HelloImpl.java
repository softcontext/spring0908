package com.example.demo.proxy5;

public class HelloImpl implements Hello {

	@Override
	public void say() {
		System.out.println("안녕하세요!");
	}

	@Override
	public void talk() {
		System.out.println("재미있는 스프링!");
	}

}
