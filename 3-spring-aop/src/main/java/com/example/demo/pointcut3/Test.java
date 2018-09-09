package com.example.demo.pointcut3;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class Test {

	public static void main(String[] args) {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		// AspectJ 프레임워크가 제안하는 대상 선택 문법을 사용하여
		// 대상 클래스와 대상 메소드를 선택합니다.
		
		// execution(표현식) = 사용하는 문법의 종류
		// * two(..) = 리턴자료형 메소드명(파라미터)
		// .. = 0~N개, 자료형은 상관 없음
		// 리턴자료형 메소드명(파라미터) 설정은 필수항목!
		
		// 메소드명이 정확하게 two인 대상만 선택한다.
//		pointcut.setExpression("execution(* two(..))");
		
		pointcut.setExpression(
			"execution(* com.example.demo.pointcut3.Second.two(..))");
		
		Advice advice = new MyAdvice();
		
		Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
		
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(new First());
		factory.addAdvisor(advisor);
				
		
		First f = (First) factory.getProxy();
		f.one();
		f.one2();
		f.two();
		f.add(2, 3);
		
		ProxyFactory factory2 = new ProxyFactory();
		factory2.setTarget(new Second());
		factory2.addAdvisor(advisor);
		
		Second s = (Second) factory2.getProxy();
		s.one();
		s.one2();
		s.two();
		s.add(2, 3);
		s.divide(2, 3);
	}

}
