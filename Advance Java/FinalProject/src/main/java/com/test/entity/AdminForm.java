package com.test.entity;

public class AdminForm {
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminForm(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public AdminForm() {
		super();
		// TODO Auto-generated constructor stub
	}

}
