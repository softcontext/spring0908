package com.example.demo.pointcut3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class MyAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("--------Around: Before-------");
		
		Object ret = invocation.proceed();
		
		System.out.println("========Around: After =======");
		
		return ret;
	}

}
