package com.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	private String mobileNo;

	private String email;

	private String password;

	private String role;
	
	private String gender;
	
	private String city;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", email=" + email + ", password="
				+ password + ", role=" + role + ", gender=" + gender + ", city=" + city + "]";
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String mobileNo, String email, String password, String role) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Employee(int id, String name, String mobileNo, String email, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Employee(int id, String name, String mobileNo, String email, String password, String role, String gender,
			String city) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.role = role;
		this.gender = gender;
		this.city = city;
	}

}
