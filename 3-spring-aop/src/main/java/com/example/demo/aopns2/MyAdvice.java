package com.example.demo.aopns2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAdvice implements MethodInterceptor {
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println(">>>>>>>> Around: Before >>>>>>>>");
		
		Object ret = invocation.proceed();
		
		System.out.println("<<<<<<<< Around: After <<<<<<<<");
		
		return ret;
	}

}
