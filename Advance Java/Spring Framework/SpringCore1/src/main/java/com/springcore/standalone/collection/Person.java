package com.springcore.standalone.collection;

import java.util.List;

public class Person {
	private List<String> freind;

	public List<String> getFreind() {
		return freind;
	}

	public void setFreind(List<String> freind) {
		this.freind = freind;
	}

	@Override
	public String toString() {
		return "Person [freind=" + freind + "]";
	}
	
	
}
