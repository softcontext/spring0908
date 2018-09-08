package com.example.demo.hw;

public class Client {
//	private Builder builder = new BigBuilder();
	private Builder builder;

	public Client() {
		
	}

	public Client(Builder builder) {
		super();
		this.builder = builder;
	}

	public void order() {
		// 고객은 건설사에 요청해서 건설하고 싶다.

		builder.build();
	}

	public Builder getBuilder() {
		return builder;
	}

	public void setBuilder(Builder builder) {
		this.builder = builder;
	}

}
