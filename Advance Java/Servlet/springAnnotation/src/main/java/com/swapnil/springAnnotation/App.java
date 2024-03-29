package com.swapnil.springAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		Samsung s1 = factory.getBean(Samsung.class);
		
		/* Saumsung s1 = new Saumsung(); */
		s1.config();
	}
}
