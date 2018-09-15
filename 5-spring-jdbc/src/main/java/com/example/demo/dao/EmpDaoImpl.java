package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Emp;

@Transactional
@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedTemplate;
	
	private SimpleJdbcInsert jdbcInsert;
	
	
	@PostConstruct
	public void init() {
		jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
			.withTableName("emp") // 테이블
			.usingGeneratedKeyColumns("empno"); // auto_increment 칼럼
	}
	

	private RowMapper<Emp> rowMapper = new RowMapper<Emp>() {
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
	public Emp insert(Emp emp) {
//		String sql = "insert into emp(empno, ename, job) "
//				+ "values(?, ?, ?)";
//		return jdbcTemplate.update(sql, 
//				emp.getEmpno(),
//				emp.getEname(),
//				emp.getJob());
		
//		String sql = "insert into emp(empno, ename, job) "
//				+ "values(:empno, :ename, :job)";
//		
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("empno", emp.getEmpno());
//		paramMap.put("ename", emp.getEname());
//		paramMap.put("job", emp.getJob());
//		
//		return namedTemplate.update(sql, paramMap);
		
//		테이블의 칼럼명과 모델클래스의 멤버변수명이 모두 같을 때
//		굳이 RowMapper 로직을 따로 만들지 않고 이름이 다 같으니
//		자동으로 처리하는(쿼리도 자동으로 생성) 기술을 사용할 수 있다.
		SqlParameterSource param = 
				new BeanPropertySqlParameterSource(emp);
		
//		데이터베이스가 로우를 인서트 하면서 자동으로 생성한 키 값
		Number key = jdbcInsert.executeAndReturnKey(param);
		
//		파라미터로 받은 객체의 empno 값은 0인 상태였는데
//		인써트 시 사용된 키 값을 넣어주고 그 객체를 재 리턴하면 
//		메소드를 호출한 측으로 키 값을 넘겨준다는 의미를 갖는다.
		emp.setEmpno(key.intValue());

		return emp;
	}

	@Override
	public int update(Emp emp) {
		String sql = "update emp "
				+ "set ename=?, job=? "
				+ "where empno=?";
		return jdbcTemplate.update(sql, 
				emp.getEname(),
				emp.getJob(),
				emp.getEmpno());
	}

	@Override
	public int delete(int empno) {
		String sql = "delete emp where empno=?";
		return jdbcTemplate.update(sql, empno);
	}

	@Override
	public Emp findOne(int empno) {
//		String sql = "select * from emp where empno=" + empno;
		
		String sql = "select * from emp where empno=?";
		
		return jdbcTemplate.queryForObject(sql, rowMapper, empno);
	}

	// 토비 스프링 3 에서 1권 참고하세요. Template Call-back Pattern
	@Override
	public int count() {
		String sql = "select count(*) from emp";
//		리턴결과 문자열이나 숫자 한개일 때 queryForObject를 사용한다.
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	@Override
	public List<Emp> findAll() {
		// SQL 작성
		String sql = "select * from emp order by empno asc";
		
		// 결과 처리
		return jdbcTemplate.query(sql, rowMapper);
	}
	
}




