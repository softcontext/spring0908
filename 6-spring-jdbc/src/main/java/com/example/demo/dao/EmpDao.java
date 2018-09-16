package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Emp;

public interface EmpDao {
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	
	public Emp findOne(int empno);
	public int count();
	public List<Emp> findAll();
}
