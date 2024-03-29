package com.sprincore.constructorInjection;

public class Person {
	private String name;
	private int personId;
	private Certificate c;

	public Person(String name, int personId, Certificate c) {
		this.name = name;
		this.personId = personId;
		this.c = c;
	}

	@Override
	public String toString() {
		return this.name+" : "+this.personId+"{"+this.c.name+"}";
	}

}
