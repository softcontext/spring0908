package com.example.demo.aopns2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
@Configuration
public class MyAspect {

//<aop:config>
//	<aop:pointcut expression="execution(* divide(int,..))" id="xxx"/>
//
//	<aop:aspect ref="myAspect">
//		<aop:before method="myBefore" pointcut-ref="xxx"/>
//		<aop:around method="myAround" pointcut-ref="xxx"/>
//		<aop:after-returning method="myAfterReturning" pointcut-ref="xxx"/>
//		<aop:after-throwing method="myAfterThrowing" pointcut-ref="xxx"/>
//		<aop:after method="myAfter" pointcut-ref="xxx"/>
//	</aop:aspect>
//</aop:config>
	
	@Pointcut("execution(* divide(int,..))")
	public void xxx() {}
	
	@Before("xxx()")
	public void myBefore(JoinPoint pjp) {
		System.out.println("--------myBefore--------");
		
		Object[] args = pjp.getArgs();
		if (args != null && args.length > 0) {
			for (Object obj : args) {
				System.out.print(obj + " ");
			}
			System.out.println();
		}
	}
	
	@Around("xxx()")
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("--------myAround : Before--------");
		
		Object ret = pjp.proceed();
		
		System.out.println("========myAround : After ========");
		
		return ret;
	}
	
	@AfterReturning("xxx()")
	public void myAfterReturning(JoinPoint pjp) {
		System.out.println("********myAfterReturning********");
	}
	
	@AfterThrowing("xxx()")
	public void myAfterThrowing(JoinPoint pjp) {
		System.out.println("~~~~~~~~myThrowing~~~~~~~~~");
	}
	
	@After("xxx()")
	public void myAfter(JoinPoint pjp) {
		System.out.println("########myAfter as Finally#########");
	}
}
