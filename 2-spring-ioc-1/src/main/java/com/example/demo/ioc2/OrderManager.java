package com.example.demo.ioc2;

// OrderManager use HyundaiMaker.
// OrderManager has HyundaiMaker. Has-A Relation
// OrderManager depend HyundaiMaker. Dependency(의존) Injection(주입)

// 요구사항이 바뀔때마다 코드 수정이 있어야 한다면 이 클래스 개발이 완료된 것인가? 아니다.
// 코드 수정이 일으키는 변화를 외부로 분리해서 관리해야 한다. ==> 환경설정 파일
// 환경설정 파일을 사용자가 직접 수정해서 이용할 수 있도록 해 주어야 한다.
// 클래스 내에 코드는 환경설정 파일의 내용에 따라서 사용할 의존객체를 선택하는 방식으로 변경한다. 
// 의존 객체가 자주 바뀌어도 코드 수정이 없도록 조치해야 한다.
// 1. 인터페이스 도입
// 2. 객체 생성 및 관리를 클래스 내에서 직접하지 않는다.
public class OrderManager {
//	private HyundaiMaker maker;
//	private KiaMaker maker;
	private CarMaker maker; // 인터페이스 도입으로 업캐스팅해서 지칭할 수 있다.
	
	public OrderManager() {
//		this.maker = new HyundaiMaker();
//		this.maker = new KiaMaker();
	}

	public void order() {
		System.out.println("OrderManager # order() called.");
		
		Money money = new Money(1000);
		System.out.println("OrderManager # " + 
				money.getAmount() + " created.");
		
		Car car = maker.sell(money);
		System.out.println("OrderManager # " + 
				car.getName() + " bought.");
	}

	public CarMaker getMaker() {
		return maker;
	}

	// order() 메소드를 이용하기 전에 
	// setMaker() 메소드를 통해서 
	// OrderManager가 사용하는(의존하는) 객체를 받는다면
	// maker 멤버변수는 더 이상 null 아니고
	// CarMaker 인터페이스를 구현한 클래스 중 하나로 만든 객체가 된다.
	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}
	
}
