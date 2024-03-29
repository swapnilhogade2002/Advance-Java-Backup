package com.springcore.SpEL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/SpEL/config.xml");
		Spel spel = context.getBean("spel", Spel.class);
		System.out.println(spel);

	}

}
