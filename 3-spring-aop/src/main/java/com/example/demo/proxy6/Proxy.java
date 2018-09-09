package com.example.demo.proxy6;

public class Proxy extends Hello {
	@Override
	public void say() {
		System.out.println("------전 처리 부가로직------");
		
		super.say();
		
		System.out.println("======후 처리 부가로직======");
	}
}
