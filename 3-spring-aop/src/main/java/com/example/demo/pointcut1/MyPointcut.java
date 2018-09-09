package com.example.demo.pointcut1;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.stereotype.Component;

@Component
public class MyPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		// 클래스는 First 이고 메소드는 one 문자열과 일치할 때 true를 리턴한다. 어드바이스 적용!
//		return targetClass == First.class 
//				&& method.getName().equals("one");
		
//		return targetClass == First.class;
		
		return method.getName().startsWith("one");
	}

}
