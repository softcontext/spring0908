package com.example.demo.lombok;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import lombok.Data;

// Java Bean 규약
// 값을 취급하는 클래스를 작성하는 규칙:
// - 멤버변수 private 붙인다. 대신 getter/setter를 제공한다.
// - 개발자의 코드와 프레임워크 코드의 연동이 잘 이루어지도록 규약을 만들었다.

@Data
// Equivalent to @Getter @Setter @RequiredArgsConstructor 
// @ToString @EqualsAndHashCode
// @Retention(RetentionPolicy.SOURCE) 이므로
// ~.java 파일을 ~.class 컴파일 하기 전 롬복이 코드를 자동으로 제너레이트 한다.
public class User {
	private String id;
	private String pwd;
	private int age;
	
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getPwd() {
//		return pwd;
//	}
//	public void setPwd(String pwd) {
//		this.pwd = pwd;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
	
}
