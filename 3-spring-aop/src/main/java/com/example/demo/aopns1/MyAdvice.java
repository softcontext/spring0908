package com.example.demo.aopns1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

// 어드바이스 용 인터페이스를 구현한 객체를 사용하면 하나의 어드바이스 메소드만을 정의할 수 있다.
@Component
public class MyAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println(">>>>>>>> Around: Before >>>>>>>>");
		
		Object ret = invocation.proceed();
		
		System.out.println("<<<<<<<< Around: After <<<<<<<<");
		
		return ret;
	}

}
