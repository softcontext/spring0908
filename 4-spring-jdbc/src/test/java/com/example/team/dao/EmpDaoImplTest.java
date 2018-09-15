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

	// 테스트 클래스 내 코드를 처리하기 전, 한번 기동한다.
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(">>>>>>> @BeforeClass >>>>>>>");
	}

	// 테스트 클래스 내 코드를 처리한 후, 한번 기동한다.
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("<<<<<<< @AfterClass <<<<<<<");
	}

	// 테스트 클래스 내 모든 @Test 테스트 메소드를 처리하기 전, 한번 기동한다.
	@Before
	public void setUp() throws Exception {
		System.out.println("------- @Before -------");
	}

	// 테스트 클래스 내 모든 @Test 테스트 메소드를 처리한 후, 한번 기동한다.
	@After
	public void tearDown() throws Exception {
		System.out.println("======= @After ========");
	}
	
	// @Test 애노테이션을 붙이면 JUnit을 통해 해당 코드를 테스트 한다.
	// @Test 테스트 메소드는 
	//  - 파라미터가 없다.
	//  - 리턴이 없다.
	//  - JUnit이 지원하는 assert~ 같은 단정메소드를 사용할 수 있다.
	//  - 메소드마다 개별적으로 라이플사이클을 갖는다.

	@Test
	public void testInsert() {
		int oldCount = dao.count();
		
		Emp emp = new Emp();
		emp.setEmpno(4001);
		emp.setEname("Aaron");
		emp.setJob("Thief");
		
		int affted = dao.insert(emp);
		System.out.println("affted = " + affted);
		assertEquals(affted, 1);
		
		int newCount = dao.count();
		
		System.out.println("oldCount = " + oldCount);
		System.out.println("newCount = " + newCount);
		assertEquals(newCount, oldCount+1);
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

}
