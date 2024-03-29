package com.swapnil.DemoHibernate;

public class AlienName {

	private String fname;
	private AlienName lname;
	private String mname;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public AlienName getLname() {
		return lname;
	}
	public void setLname(AlienName lname) {
		this.lname = lname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	@Override
	public String toString() {
		return "AlienName [fname=" + fname + ", lname=" + lname + ", mname=" + mname + "]";
	}

	
}
