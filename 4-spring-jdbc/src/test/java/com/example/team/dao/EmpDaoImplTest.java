package com.example.team.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.team.model.Emp;

// 스프링 테스트를 통해서 JUnit 기술을 사용한다.
@RunWith(SpringJUnit4ClassRunner.class)
// root-context.xml을 빈컨테이너 구성설정 파일로 사용한다.
@ContextConfiguration(locations= {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class EmpDaoImplTest {
	@Autowired
	private EmpDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		int oldCount = dao.count();
		
		Emp emp = new Emp();
		emp.setEmpno(4001);
		emp.setEname("Aaron");
		emp.setJob("Thief");
		
		int affted = dao.insert(emp);
		System.out.println("affted = " + affted);
		
		int newCount = dao.count();
		
		System.out.println("oldCount = " + oldCount);
		System.out.println("newCount = " + newCount);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
		// TODO: 테스트 시나리오를 짜고 테스트 코드를 작성하세요.
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
		// TODO: 테스트 시나리오를 짜고 테스트 코드를 작성하세요.
	}

	@Test
	public void testFindOne() {
		Emp emp = dao.findOne(7788);
		System.out.println(emp);
	}

	@Test
	public void testCount() {
		int count = dao.count();
		System.out.println("count = " + count);
	}

	@Test
	public void testFindAll() {
		List<Emp> emps = dao.findAll();
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

}
