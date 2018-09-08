package com.example.demo.lombok;

public class Test {

	public static void main(String[] args) {
		User user = new User();
		user.setId("goodid");
		user.setPwd("1234");
		user.setAge(22);
		
		System.out.println(user.getId());
		System.out.println(user.toString());
	}

}
