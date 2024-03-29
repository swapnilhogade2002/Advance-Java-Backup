package com.springcore.SpEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Spel {
	@Value("#{2+3}")
	private int x;

	@Value("#{33+66}")
	private int y;

//	static metod calling in spel
	@Value("#{T(java.lang.Math).sqrt(144)}")
	private int z;
	
//	boolean type in spel
	@Value("#{8>6}")
	private boolean isActive;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Spel [x=" + x + ", y=" + y + ", z=" + z + ", isActive=" + isActive + "]";
	}

	
}
