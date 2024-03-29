package com.sprincore.lifecycleOfBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sprincore/lifecycleOfBean/config.xml");

//		bean configuration using xml
		
//		Samosa s1 = (Samosa) context.getBean("s1");
//		System.out.println(s1);	
//		((AbstractApplicationContext) context).registerShutdownHook();
		
//	been configuration using spring interface
		
//		Pepsi p1 = (Pepsi) context.getBean("p1");
//		System.out.println(p1);
//		((AbstractApplicationContext) context).registerShutdownHook();
		
//	been configuration using @Annotation
		
		Icecream I1 = (Icecream) context.getBean("I1");
		System.out.println(I1);
		((AbstractApplicationContext) context).registerShutdownHook();
		

	}

}
