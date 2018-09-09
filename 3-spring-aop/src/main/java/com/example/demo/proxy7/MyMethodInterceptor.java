package com.example.demo.proxy7;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("------around : before advice------");
		
//		super.say(); 
		// 범용적으로 부가로직을, 모든 타겟객체의 메소드들을 대상으로
		// 프록싱하기 위해서 위 방법을 사용하지 않는다.
		
		Object ret = invocation.proceed(); // Delegation
		
		System.out.println("======around : after advice======");
		
		return ret;
	}

}
