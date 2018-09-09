package com.example.demo.proxy2;

public class HelloImpl implements Hello {

	@Override
	public void say() {
//		System.out.println("-----전 처리 부가로직-----");
				
		// 항상 작동해야 로직: Core Concern
		System.out.println("안녕하세요!");
		
//		System.out.println("=====후 처리 부가로직=====");
	}

//	@Override
	public void sayWithAdvice() {
		System.out.println("-----전 처리 부가로직-----");
				
		// 항상 작동해야 로직: Core Concern
		say();
		
		System.out.println("=====후 처리 부가로직=====");
	}
}
