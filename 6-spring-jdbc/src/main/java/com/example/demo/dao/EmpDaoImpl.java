package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Emp;

//@Component
//@Transactional(
//	isolation=Isolation.DEFAULT,
//	propagation=Propagation.REQUIRED,
//	readOnly=false,
//	timeout=-1,
//	rollbackFor=RuntimeException.class
//)
@Repository
public class EmpDaoImpl implements EmpDao {
//	@Autowired
	private JdbcTemplate jdbcTemplate;
//	@Autowired
//	private NamedParameterJdbcTemplate namedTemplate;

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
	
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
//	@Transactional
	@Override
	public int insert(Emp emp) {
		String sql = "insert into emp9(empno, ename, job) " + 
					"values(?, ?, ?)";
		
		int affeted = jdbcTemplate.update(sql, 
				emp.getEmpno(), emp.getEname(), emp.getJob());
		
		
		
//		String sql = "insert into emp9(empno, ename, job) "
//				+ "values(:empno, :ename, :job)";
//		
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("empno", emp.getEmpno());
//		paramMap.put("ename", emp.getEname());
//		paramMap.put("job", emp.getJob());
//		
//		int affeted = namedTemplate.update(sql, paramMap);
		
		
		
		System.out.println(">>> 1 inserted.");
		
		int x = 3 / 0; 
		// Unchecked Exception 발생 >> 트랜잭션 어드바이스가 롤백을 수행한다.
		
		return affeted;
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

//	@Transactional(readOnly=true)
	@Override
	public Emp findOne(int empno) {
		String sql = "select * from emp9 where empno=?";
		return jdbcTemplate.queryForObject(sql, rowMapper, empno);
	}

	@Override
	public int count() {
		String sql = "select count(*) from emp9";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	@Override
	public List<Emp> findAll() {
		String sql = "select * from emp9 order by empno asc";
		return jdbcTemplate.query(sql, rowMapper);
	}
	
}




