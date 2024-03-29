package com.springcore.autowiringUsingAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/autowiringUsingAnnotation/config.xml");
		Emp emp1=(Emp) context.getBean("emp1");
		System.out.println(emp1);

	}

}
