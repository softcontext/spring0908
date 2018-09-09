package com.example.demo.proxy7;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;

public class Test {

	public static void main(String[] args) {
		Hello hello = new Hello();
		hello.say();
		
		System.out.println();
		
//		Hello proxy = new Proxy();
		
		// CGI Dynamic Proxy
		// 부가로직을 갖고 있는 객체를 어드바이스라고 부른다.
		Advice advice = new MyMethodInterceptor();
		
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(hello);
		factory.addAdvice(advice);
		
		Hello proxy = (Hello) factory.getProxy();
		proxy.say();
		
		// 결론
		// 1. 타겟 클래스가 인터페이스를 구현
		// >> JDK Dynamic Proxy
		
		// 2. 타겟 클래스는 인터페이스와 무관
		// >> CGI Dynamic Proxy
		
	}

}




