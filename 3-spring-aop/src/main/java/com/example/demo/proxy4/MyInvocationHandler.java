package com.example.demo.proxy4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
 * 클라이언트 ==프록시:전 처리 부가로직 ==> 타겟 메소드
 * 								코어 컨선 로직 수행 >> 리턴
 * 클라이언트 <==프록시:후 처리 부가로직 == 타겟 메소드
 */
public class MyInvocationHandler implements InvocationHandler {
	// 어떠한 타겟 객체라도 프록싱 하기 위해서 자료형을 업캐스팅한다.
	private Object target;

	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("-----전 처리 부가로직-----");

		// 이 방법은 특정 자료형의 종속되어 범용적으로 사용할 수 없으므로 이용하지 않는다.
//		target.say(); 
		
		// 다운 캐스팅을 하지 않고도 타겟 객체의 메소드를 호출하는 방법이 필요하다.
		// Method 자료형의 객체는 프록싱할 타겟 메소드 정보를 취급합니다.
		// method 변수는 호출할 메소드정보를 알고 있습니다.
		// 다음 코드는 target 객체의 존재하는 메소드를 
		// args 파라미터를 주고 호출하라는 뜻입니다.
		Object ret = method.invoke(target, args); // 위임: Delegation

		System.out.println("=====후 처리 부가로직=====");
		
		// 타겟 객체의 메소드가 처리결과로 리턴하는 값을 프록시가 재 리턴하여
		// 클라이언트에게 전달합니다.
		return ret;
	}

}
