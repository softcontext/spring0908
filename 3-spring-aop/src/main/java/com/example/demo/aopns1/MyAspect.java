package com.example.demo.aopns1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

// 인터페이스를 구현하지 않고 aop 네임스페이스 태그를 사용하여
// 어드바이스의 용도를 설정하는 방식으로 대체하면 하나의 클래스 내에
// 다수의 어드바이스 로직 메소드를 보유할 수 있습니다.
@Component
public class MyAspect {

	public void myBefore(JoinPoint pjp) {
		System.out.println("--------myBefore--------");
		
		Object[] args = pjp.getArgs();
		if (args != null && args.length > 0) {
			for (Object obj : args) {
				System.out.print(obj + " ");
			}
			System.out.println();
		}
		
		// 비포 어드바이스 후에 타겟 메소드가 호출 됩니다.
	}
	
	// 프록시가 타겟 메소드가 리턴한 결과를 조작해서
	// 클라이언트게 주고 싶다면 어라운드 어드바이스를 사용해야 한다.
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("--------myAround : Before--------");
		
		// 타겟 메소드를 호출하는 코드가 있어야 한다.
		Object ret = pjp.proceed();
		
		System.out.println("========myAround : After ========");
		
		return ret;
	}
	
	
	
	// 타겟 메소드가 정상적으로 작동한 후
	public void myAfterReturning(JoinPoint pjp, Object result) {
		System.out.println("********myAfterReturning********");
		System.out.println("result = " + result);
	}
	// 타겟 메소드가 작동하다가 예외가 발생한 후
	public void myAfterThrowing(JoinPoint pjp, Throwable e) {
		System.out.println("~~~~~~~~myThrowing~~~~~~~~~");
		System.out.println("e = " + e.getMessage());
	}
	// 타겟 메소드가 정상/예외 상관없이 그 후에 항상 기동
	public void myAfter(JoinPoint pjp) {
		System.out.println("########myAfter as Finally#########");
	}
}
