package com.example.demo.proxy6;

public class Test {

	public static void main(String[] args) {
		Hello hello = new Hello();
		hello.say();
		
		System.out.println();
		
		Hello proxy = new Proxy();
		proxy.say();
	}

}
