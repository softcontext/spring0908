package com.example.demo.ioc2;

public class Test {
	// OrderManager 클래스를 변화에 강하도록 만든 결과
	// new 키워드가 OrderManager 객체를 사용하는 그 앞에 객체인
	// Test로 이동되었다.
	// Test 클래스도 역시 변화에 강하도록 만들기 위해서
	// 객체를 생성하고 관리하는 주체를 완전히 분리해서 사용할 필요가 있다.
	// 이 부분을 프레임워크가 대신 수행한다.
	public static void main(String[] args) {
//		CarMaker maker = new HyundaiMaker();
		CarMaker maker = new KiaMaker();
		
		OrderManager manager = new OrderManager();
		manager.setMaker(maker); // DI
		manager.order();
	}

}











