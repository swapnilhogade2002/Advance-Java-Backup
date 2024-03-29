package com.spring.orm.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//        Student student = new Student(1,"swapnil hogade","nashik");
//        int i = studentDao.insert(student);
//        System.out.println("success"+i);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean go = true;
		while (go) {
			System.out.println("Press 1 : Add Student");
			System.out.println("Press 2 : Display Student");
			System.out.println("Press 3 : Get Detail of single  Student");
			System.out.println("Press 4 : Delete Student");
			System.out.println("Press 5 : Update Student");
			System.out.println("Press 6 : Exit");

			try {
				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					// add student
					System.out.println("Enter Student id: ");
					int uId = Integer.parseInt(br.readLine());

					System.out.println("Enter Name");
					String uName = br.readLine();

					System.out.println("Enter City");
					String uCity = br.readLine();

					Student s = new Student();
					s.setStudentId(uId); // Use the entered studentId
					s.setStudentName(uName);
					s.setStudentCity(uCity);

					int insert = studentDao.insert(s);
					System.out.println("Student inserted");
					break;

				case 2:
//					display all student
					List<Student> allStudent = studentDao.getAllStudent();
					for (Student st : allStudent) {
						System.out.println("Id" + st.getStudentId());
						System.out.println("Name" + st.getStudentName());
						System.out.println("City" + st.getStudentCity());
						System.out.println("*********************************");
					}
					break;

				case 3:
//					get single student
					System.out.println("Enter user Id: ");
					int userID = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(userID);
					System.out.println("Id" + student.getStudentId());
					System.out.println("Name" + student.getStudentName());
					System.out.println("City" + student.getStudentCity());
					System.out.println("*********************************");

					break;

				case 4:
//					delete student
					System.out.println("Enter Id:");
					int del = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(del);
					System.out.println("student deleted succesfully");
					break;

				case 5:
					break;

				case 6:

					go = false;
					break;

				}

			} catch (Exception e) {
				System.out.println("Invalid input try another one!");
				System.out.println(e.getMessage());
			}

		}

	}
}