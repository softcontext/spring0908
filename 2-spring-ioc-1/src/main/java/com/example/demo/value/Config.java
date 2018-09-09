package com.example.demo.value;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.ToString;

@ToString
@Configuration
//@PropertySource(value = { "app.properties" })
public class Config {
	@Value("string value") // “string value” 라는 값자체를 주입
	private String name;
	
	@Value("${value.from.file}") // “Value got from the file” 라는 값이 주입
	private String valueFromFile;
	
	@Value("${listOfValues}") // “A”, “B”, “C” 라는 문자열 배열이 주입
	private String[] valuesArray;
	
	@Value("${java.version}")
	private String javaVersion;
	
	// java -jar 배포파일.jar -D 옵션으로 주는 값에 대해서 아래와 같이 읽을 수 있다.
	@Value("#{ systemProperties['user.region'] == null ? 'KR' : systemProperties['user.region']}") // KR
	private String defaultLocale;

}
