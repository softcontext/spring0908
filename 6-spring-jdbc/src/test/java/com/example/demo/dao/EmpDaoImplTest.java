package com.example.demo.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class EmpDaoImplTest {
	@Autowired
	private EmpDao dao;

//	@Transactional + @Test: 테스트 메소드 수행 후 자동으로 롤백을 한다.
//	테스트 시 수정한 부분을 롤백하는 것이 맞다.
//	@Transactional
	@Test
	public void testInsert() {
		int oldCount = dao.count();
		System.out.println("oldCount = " + oldCount);
		
		Emp emp = new Emp();
		emp.setEmpno(4001);
		emp.setEname("Aaron");
		emp.setJob("Thief");

		int affted = 0;
		try {
			affted = dao.insert(emp);
		} catch (Exception e) {
			System.out.println("------------------");
			System.out.println(e.getMessage());
		}
		
		System.out.println("affted = " + affted);
		assertEquals(affted, 1);

		int newCount = dao.count();
		System.out.println("newCount = " + newCount);
		assertEquals(newCount, oldCount + 1);
	}

}
