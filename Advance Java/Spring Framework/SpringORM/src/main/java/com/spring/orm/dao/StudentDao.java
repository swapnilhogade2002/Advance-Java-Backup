package com.spring.orm.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int insert(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;

	}
//	taking single data from database
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get( Student.class, studentId);
		return student;	
	}
	
//	taking multiple data from database
	public List<Student> getAllStudent() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
		
	}
	
//	deleting data
//	public void deleteStudent(int studentId) {
//		Student student = this.hibernateTemplate.get(Student.class, studentId);
//		this.hibernateTemplate.delete(student);
//		
//	}
	@Transactional(readOnly = false)
	public void deleteStudent(int studentId) {
	    String query = "DELETE FROM student WHERE studentId = ?";
	    hibernateTemplate.update(query, studentId);
	}

	
	
	
//	update student
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
		
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
