package com.example.demo.proxy4;

import java.lang.reflect.Proxy;

import org.springframework.stereotype.Component;

@Component
public class Test {
	/*
	 * 프록시 패턴과 스프링 IoC 컨테이너를 사용하면 클라이언트 코드의 변경이 없어도
	 * 코어컨선만 작동 시키거나 부가로직도 같이 작동시킬 수 있다는 것을 살펴보았다.
	 * 하지만, 매번 프록시 클래스를 개발자가 만들어야 한다면 굉장히 부담스럽다.
	 * >> 프록시 객체를 자동으로 만들어 주는 기술이 필요하다.
	 */
	public static void main(String[] args) {
		Hello hello = new HelloImpl();
		
		// 메소드가 제공하는 기능만을 사용한다.
		hello.say();
		hello.talk();
		
		System.out.println();
		
		// 고객이 서비스 로직을 갖고 있는 모습이므로 좋지 않다.
		// 메소드 앞에 전처리 기능과 메소드 후처리 기능을 추가적으로 수행하고 싶다.
//		Hello proxy = new Proxy(hello);
		
		// JDK Dynamic Proxy
		Hello proxy = (Hello) Proxy.newProxyInstance(
				Hello.class.getClassLoader(), 
				new Class<?>[] {Hello.class}, 
				new MyInvocationHandler(hello));
		
		proxy.say();
		proxy.talk();
		
		// 스프링은 타겟 클래스가 인터페이스를 구현했다면
		// JDK Dynamic Proxy 기술을 사용하여 동적으로 프록시 객체를
		// 만들 수 있으므로 개발자에게 별도로 프록시 클래스를 요구하지 않습니다.
	}

}




