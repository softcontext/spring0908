package com.example.demo.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.board.model.Board;

//마이바티스에게 요청: 인터페이스 구현 클래스를 개발자 대신 만들어서
//빈 컨테이너 등록하라고 요청합니다. 등록되는 객체는 일종의 프록시입니다.
//프록시 내 로직은 Lazy하게 작동하므로 실제 메소드가 호출될 때 마이타비스 처리로직이
//질의업무를 대신 수행합니다.
@Mapper
public interface BoardDao {
	public int insert(Board board);
	public int update(Board board);
	public int delete(int id);
	
	@Select("select count(*) from board")
	public int count();
	
	@Select("select * from board order by id desc")
	public List<Board> findAll();
	
	public Board findOne(int id);
	
	public List<Board> findLimit(
			@Param("page") int page, 
			@Param("size") int size);
}








