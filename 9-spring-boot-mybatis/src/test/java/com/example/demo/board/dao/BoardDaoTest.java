package com.example.demo.board.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.model.Board;

//SpringRunner 클래스를 통해서 JUnit 프레임워크를 사용합니다.
@RunWith(SpringRunner.class)
//테스트를 위한 빈 컨테이너 설정을 진행하라. 서비스 환경과 동일한 컨테이너를 이용하여
//테스트를 진행하고자 한다.
@SpringBootTest
public class BoardDaoTest {
	@Autowired
	private BoardDao dao;
	
	@Test
	public void testBed() {
		System.out.println(dao);
		assertNotNull(dao);
	}

	@Transactional
	@Test
	public void testInsert() {
		int old_count = dao.count();
		System.out.println(old_count);
		
		Board board = new Board();
		board.setWriter("writer");
		board.setContent("content");
		board.setTitle("title");
		
		int affeted = dao.insert(board);
		System.out.println("affeted = " + affeted);
		
		int new_count = dao.count();
		System.out.println(new_count);
		
		assertThat(new_count, is(old_count + 1));
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testCount() {
		int count = dao.count();
		
//		assert that count is not 0.
		assertThat(count, is(not(0)));
		
		System.out.println("count = " + count);
	}

	@Test
	public void testFindAll() {
		List<Board> boards = dao.findAll();
		assertNotNull(boards);
		
		for (Board board : boards) {
			System.out.println(board);
		}
	}

	@Test
	public void testFindOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindLimit() {
		testFindAll();
		System.out.println("------------");
		
		int size = 5;
		int page = 2;
		
		List<Board> boards = dao.findLimit(page, size);
		for (Board board : boards) {
			System.out.println(board);
		}
	}

}
