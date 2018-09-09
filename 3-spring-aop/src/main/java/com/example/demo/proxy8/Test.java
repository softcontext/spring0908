package com.example.demo.proxy8;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
//		Hello hello = new Hello();
//		hello.say();
//		
//		System.out.println();
//		
//		Advice advice = new MyMethodInterceptor();
//		
//		ProxyFactory factory = new ProxyFactory();
//		factory.setTarget(hello);
//		factory.addAdvice(advice);
//		
//		Hello proxy = (Hello) factory.getProxy();
//		proxy.say();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"proxy-config.xml");
		
		Hello hello = context.getBean("hello", Hello.class);
		hello.say();
		
		Hello proxy = context.getBean("proxy", Hello.class);
		proxy.say();
	}

}




