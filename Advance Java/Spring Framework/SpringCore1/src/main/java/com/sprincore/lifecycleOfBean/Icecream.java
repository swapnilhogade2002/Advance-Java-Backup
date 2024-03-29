package com.sprincore.lifecycleOfBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Icecream {
	private String name;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Icecream [name=" + name + "]";
	}
	
	@PostConstruct
	public void start() {
		System.out.println("Icecream: init");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Icecream: destroy");
	}
	
}
