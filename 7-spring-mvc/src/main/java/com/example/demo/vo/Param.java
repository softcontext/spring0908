package com.example.demo.vo;

public class Param {
	private String key;
	private String param;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	
	@Override
	public String toString() {
		return "Param [key=" + key + ", param=" + param + "]";
	}
}
