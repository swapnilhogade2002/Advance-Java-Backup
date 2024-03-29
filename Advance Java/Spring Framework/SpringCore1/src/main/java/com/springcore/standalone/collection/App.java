package com.springcore.standalone.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext con = new ClassPathXmlApplicationContext("com/springcore/standalone/collection/config.xml");
		Person persion1 =  con.getBean("person1",Person.class);
		System.out.println(persion1);
		System.out.println(persion1.getFreind().getClass().getName());
	}

}
