package com.swapnil.Mavean;

public class Tyre {

	private String brand;

// getter & setter 
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
//	to string method
	@Override
	public String toString() {
		return "Tyre [brand=" + brand + "]";
	}


}
