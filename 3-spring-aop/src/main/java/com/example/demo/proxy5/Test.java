package com.example.demo.proxy5;

import java.lang.reflect.Proxy;

import org.springframework.stereotype.Component;

@Component
public class Test {
	public static void main(String[] args) {
		Hello hello = new HelloImpl();
		
		// Target 객체를 그대로 사용한다.
		hello.say();
		hello.talk();
		
		System.out.println();
		
		// Proxy(Target 객체 소유) 객체를 사용한다.
		Hello proxy = (Hello) Proxy.newProxyInstance(
				Hello.class.getClassLoader(), 
				new Class<?>[] {Hello.class}, 
				new MyInvocationHandler(hello));
		
		proxy.say();
		proxy.talk();
		
		
	}

}




