package com.swapnil.Mavean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

//        Vehicle car = (Vehicle) context.getBean("car");
//        car.drive();

		Tyre t = (Tyre) context.getBean("Tyre");
		System.out.println(t);
	}
}
