package com.job.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String email;
	private String password;
	private Long mobile;
	private String work;
	private String city;

	private String file;

	private String role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<JobPosting> jobPostings = new ArrayList<>();

	// Constructors, getters, setters, and other methods

	// Add a method to add job posting to the user
	public void addJobPosting(JobPosting jobPosting) {
		jobPostings.add(jobPosting);
		jobPosting.setUser(this);
	}

	// Add a method to remove job posting from the user
	public void removeJobPosting(JobPosting jobPosting) {
		jobPostings.remove(jobPosting);
		jobPosting.setUser(null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<JobPosting> getJobPostings() {
		return jobPostings;
	}

	public void setJobPostings(List<JobPosting> jobPostings) {
		this.jobPostings = jobPostings;
	}

	// Default constructor
	public User() {
	}

	// Constructor with essential fields
	public User(String name, String email, String password, Long mobile, String work, String city, String file,
			String role) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.work = work;
		this.city = city;
		this.file = file;
		this.role = role;
	}

	public void setAcceptedForJob(boolean b) {
		// TODO Auto-generated method stub
		
	}

	
	

}
