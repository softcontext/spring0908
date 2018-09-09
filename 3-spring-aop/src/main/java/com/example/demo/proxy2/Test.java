package com.example.demo.proxy2;

public class Test {

	public static void main(String[] args) {
		Hello hello = new HelloImpl();
		
		// 메소드가 제공하는 기능만을 사용한다.
		hello.say();
		
		System.out.println();
		
		// 고객이 서비스 로직을 갖고 있는 모습이므로 좋지 않다.
		// 메소드 앞에 전처리 기능과 메소드 후처리 기능을 추가적으로 수행하고 싶다.
//		hello.say();
		((HelloImpl)hello).sayWithAdvice();
	}

}
