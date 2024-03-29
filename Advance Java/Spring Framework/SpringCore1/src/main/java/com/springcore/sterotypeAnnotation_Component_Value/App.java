package com.springcore.sterotypeAnnotation_Component_Value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("com/springcore/sterotypeAnnotation_Component_Value/config.xml");
		Student student = (Student) con.getBean("student", Student.class);
//		System.out.println(student);
		
//		spring bean scope: singletone , prototype
		System.out.println(student.hashCode());
		
		Student student2 = con.getBean("student",Student.class);
		System.out.println(student2.hashCode());
		
//		scope("prototype ") using xml
		Student teacher1 =con.getBean("teacher",Student.class);
		Student teacher2 =con.getBean("teacher",Student.class);
		 
		System.out.println(teacher1.hashCode());		
		System.out.println(teacher2.hashCode());

	}

}
