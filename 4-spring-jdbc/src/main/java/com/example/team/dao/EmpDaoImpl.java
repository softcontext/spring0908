package com.example.team.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.team.model.Emp;

//@Component
@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	@Autowired
//	public void setDataSource(DataSource dataSource) {
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
//	}
	
	@Override
	public int insert(Emp emp) {
		
		return 0;
	}

	@Override
	public int update(Emp emp) {
		
		return 0;
	}

	@Override
	public int delete(int empno) {
		
		return 0;
	}

	@Override
	public Emp findOne(int empno) {
		
		return null;
	}

	@Override
	public int count() {
		
		return 0;
	}

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
	
	@Override
	public List<Emp> findAll() {
		// SQL 작성
		String sql = "select * from emp9 order by empno asc";
		
		// 결과 처리
		return jdbcTemplate.query(sql, rowMapper);
	}

	public static void main(String[] args) {
//		EmpDao dao = new EmpDaoImpl();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		
		EmpDao dao = context.getBean("empDaoImpl", EmpDao.class);
				
		List<Emp> emps = dao.findAll();
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}
	
}




