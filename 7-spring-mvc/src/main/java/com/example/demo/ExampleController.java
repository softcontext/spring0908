package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.vo.Param;

//http://localhost:8080/demo/example
@RequestMapping(value="/example")
@Controller
public class ExampleController { // URLHandler

	//http://localhost:8080/demo/example/data
	@RequestMapping(value="/data", method=RequestMethod.GET)
	public String getData() {
		return "example-data-get"; // View를 가리키는 키워드
	}
	
	//http://localhost:8080/demo/example/data
	@RequestMapping(value="/data", method=RequestMethod.POST)
	public String postData(HttpServletRequest req,
			Param param) {
		
		String key = req.getParameter("key");
		System.out.println("key = " + key);
		String color = req.getParameter("color");
		System.out.println("color = " + color);
		
		System.out.println(param);
		
		return "example-data-post"; // View를 가리키는 키워드
	}
}








