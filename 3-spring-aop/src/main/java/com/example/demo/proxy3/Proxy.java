package com.example.demo.proxy3;

public class Proxy implements Hello {
	private Hello hello;

	public Proxy(Hello hello) {
		super();
		this.hello = hello;
	}

	@Override
	public void say() {
		System.out.println("-----전 처리 부가로직-----");

		// 위임 : Delegation
		hello.say();

		System.out.println("=====후 처리 부가로직=====");
	}

}
