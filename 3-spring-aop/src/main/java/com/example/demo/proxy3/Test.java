package com.example.demo.proxy3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test {
	// 스프링이 DI하는 객체를 주입받아서 사용합니다. 
	// 스프링이 HelloImpl 객체를 주면 코어컨선 로직만 수행됩니다.
	// 스프링이 대신 Proxy 객체를 주면 코어컨선 로직 + 부가로직도 수행됩니다.
	// HelloImpl, Proxy 모두 인터페이스 Hello를 구현했으므로
	// 클라이언트가 가진 멤버변수의 자료형은 어떤 객체를 주입하더라도 변경되지 않습니다.
	@Autowired
	private Hello hello;
	
	public void useHello() {
		hello.say();
	}
	
	
	//***********절 취 선(위 코드가 실제 사용 모습)************

	
	public static void main(String[] args) {
		Hello hello = new HelloImpl();
		
		// 메소드가 제공하는 기능만을 사용한다.
		hello.say();
		
		System.out.println();
		
		// 고객이 서비스 로직을 갖고 있는 모습이므로 좋지 않다.
		// 메소드 앞에 전처리 기능과 메소드 후처리 기능을 추가적으로 수행하고 싶다.
		Hello proxy = new Proxy(hello);
		
		proxy.say();
	}

}
