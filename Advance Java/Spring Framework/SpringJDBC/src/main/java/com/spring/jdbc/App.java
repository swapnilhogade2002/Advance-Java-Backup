package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("Program started successfully!!!");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//        new work culture
//  	  insert        
//        Student student = new Student();
//        student.setId(4);
//        student.setName("ganesh");
//        student.setCity("mumbai"); 
//        int res = studentDao.insert(student);
//        System.out.println("student added sucesfully"+ res);

// 		  update
//        Student student = new Student();
//        student.setId(2);
//        student.setCity("Delhi");
//        student.setName("Neha");
//        
//        int change = studentDao.change(student);
//        System.out.println("data is changed"+change);

//        delete
//         int res=studentDao.delete(4);
//         System.out.println("Record deleted succesfully!" +res);

//        old work culture
//        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

		// Insert query
//        String query = "insert into student (id, name, city) values (?, ?, ?)";

		// Execute query
//        jdbcTemplate.update(query, 3, "shree", "kailas");
//        System.out.println("Added successfully!");

//        selecting single data from database
//        Student student = studentDao.getStudent(2);
//        System.out.println(student);

		List<Student> students = studentDao.getAllStudents();
		for (Student s : students) {
			System.out.println(s);
		}
	}
}
