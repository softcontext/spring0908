package com.example.demo.proxy5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
	private Object target;

	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("-----전 처리 부가로직-----");

		Object ret = method.invoke(target, args); // 위임: Delegation

		System.out.println("=====후 처리 부가로직=====");
		
		return ret;
	}

}
