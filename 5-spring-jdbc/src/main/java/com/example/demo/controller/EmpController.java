package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmpDao;
import com.example.demo.model.Emp;

// Servlet : 서블릿 프레임워크에서 브라우저와 대화하는 객체
// Controller : 스프링 프레임워크에서 브라우저와 대화하는 객체
@RestController
public class EmpController {
	@Autowired
	private EmpDao empDao;

//	http://localhost:8080/
	@GetMapping({"/", "/emps"})
	public List<Emp> getEmpAll(){
		List<Emp> emps = empDao.findAll();
		return emps;
	}
	
//	http://localhost:8080/
	@PostMapping({"/emps"})
	public Emp postOne(@RequestBody Emp emp){
		System.out.println("-------------------");
		System.out.println(emp);
		System.out.println("===================");
		
		return empDao.insert(emp);
	}
}




