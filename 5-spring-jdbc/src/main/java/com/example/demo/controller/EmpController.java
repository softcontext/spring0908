package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmpDao;
import com.example.demo.model.Emp;

// Servlet : 서블릿 프레임워크에서 브라우저와 대화하는 객체
// Controller : 스프링 프레임워크에서 브라우저와 대화하는 객체
@RestController
public class EmpController {
	@Autowired
	private EmpDao empDao;

	@RequestMapping({"/", "/emps"})
	public List<Emp> getEmpAll(){
		List<Emp> emps = empDao.findAll();
		return emps;
	}
}




