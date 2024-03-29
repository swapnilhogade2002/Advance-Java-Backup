package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {
	private JdbcTemplate jdbcTemplate;

//	insert 
	@Override
	public int insert(Student student) {
		String query = "insert into student (id, name, city) values (?, ?, ?)";
		int update = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return update;
	}

// 	update
	@Override
	public int change(Student student) {
		String query = "update student set name=? , city=? where id= ?";
		int r = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return r;
	}

//	delete
	@Override
	public int delete(int studentID) {
		String query = "delete from student where id=?";
		int update = this.jdbcTemplate.update(query, studentID);
		System.out.println(update);

		return 0;
	}

//	selecting single obj from jdbc
	@Override
	public Student getStudent(int studentId) {
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student =this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}
	
//	selecting multiple object from database
	@Override
	public List<Student> getAllStudents() {
		String query ="select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}
