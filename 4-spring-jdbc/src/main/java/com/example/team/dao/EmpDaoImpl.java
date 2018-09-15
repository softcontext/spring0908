package com.example.team.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.team.model.Emp;

//@Component
@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedTemplate;

	private RowMapper<Emp> rowMapper = new RowMapper<Emp>() {
//		테이블 한 로우의 칼럼들의 정보를 꺼내서
//		Emp 객체의 멤버변수의 옮겨담는 로직이 있는 메소드
		@Override
		public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
			Emp e = new Emp();
			e.setEmpno(rs.getInt("empno"));
			e.setEname(rs.getString("ename"));
			e.setJob(rs.getString("job"));
			
			return e;
		}
	};
	
//	@Autowired
//	public void setDataSource(DataSource dataSource) {
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
//	}
	
	@Override
	public int insert(Emp emp) {
//		String sql = "insert into emp9(empno, ename, job) "
//				+ "values(?, ?, ?)";
//		return jdbcTemplate.update(sql, 
//				emp.getEmpno(),
//				emp.getEname(),
//				emp.getJob());
		
		String sql = "insert into emp9(empno, ename, job) "
				+ "values(:empno, :ename, :job)";
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("empno", emp.getEmpno());
		paramMap.put("ename", emp.getEname());
		paramMap.put("job", emp.getJob());
		
		return namedTemplate.update(sql, paramMap);
	}

	@Override
	public int update(Emp emp) {
		String sql = "update emp9 "
				+ "set ename=?, job=? "
				+ "where empno=?";
		return jdbcTemplate.update(sql, 
				emp.getEname(),
				emp.getJob(),
				emp.getEmpno());
	}

	@Override
	public int delete(int empno) {
		String sql = "delete emp9 where empno=?";
		return jdbcTemplate.update(sql, empno);
	}

	@Override
	public Emp findOne(int empno) {
//		String sql = "select * from emp9 where empno=" + empno;
		
		String sql = "select * from emp9 where empno=?";
		
		return jdbcTemplate.queryForObject(sql, rowMapper, empno);
	}

	// 토비 스프링 3 에서 1권 참고하세요. Template Call-back Pattern
	@Override
	public int count() {
		String sql = "select count(*) from emp9";
//		리턴결과 문자열이나 숫자 한개일 때 queryForObject를 사용한다.
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	@Override
	public List<Emp> findAll() {
		// SQL 작성
		String sql = "select * from emp9 order by empno asc";
		
		// 결과 처리
		return jdbcTemplate.query(sql, rowMapper);
	}

	// TEST
	// 개발자가 작성한 메소드가 제대로 작동하는지 테스트를 위해서 사용하고 있습니다.
	public static void main(String[] args) {
//		EmpDao dao = new EmpDaoImpl();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		
		EmpDao dao = context.getBean("empDaoImpl", EmpDao.class);
				
//		testFindAll(dao);
		
//		testCount(dao);
		
		testFindOne(dao);

	}

	private static void testFindOne(EmpDao dao) {
		Emp emp = dao.findOne(7788);
		System.out.println(emp);
	}

	private static void testCount(EmpDao dao) {
		int count = dao.count();
		System.out.println("count = " + count);
	}

	private static void testFindAll(EmpDao dao) {
		List<Emp> emps = dao.findAll();
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}
	
}




