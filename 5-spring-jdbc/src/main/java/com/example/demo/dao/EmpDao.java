package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Emp;

// Data Access Object
public interface EmpDao {
	// 테이블의 데이터를 조작하는 기능
	// 리턴 값: 영향받은 로우의 개수
	public Emp insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	
	// 테이블의 데이터를 조회하는 기능
	public Emp findOne(int empno);
	public int count();
	public List<Emp> findAll();
}
