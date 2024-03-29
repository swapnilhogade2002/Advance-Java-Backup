package com.springcore.sterotypeAnnotation_Component_Value;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("student")
// use of prototype
@Scope("prototype")
public class Student {
	
	@Value("swapnil")
	private String name;
	
//	collection with @Value
	@Value("#{CollectionWithValue}")
	private List<String> City;

//	collection with @Value get() set()
	public List<String> getCity() {
		return City;
	}

	public void setCity(List<String> city) {
		City = city;
	}
	
//	collection with @Value toString()
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "Student [name=" + name + ", City=" + City + "]";
	}
	
	
}
