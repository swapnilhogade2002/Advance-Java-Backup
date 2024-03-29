package com.job.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class JobPosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String profile;
	private String location;
	private String workMode;
	private String jobType;
	private String experience;
	private Double ctc;
	private String detail;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private User user;
	

   
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWorkMode() {
		return workMode;
	}

	public void setWorkMode(String workMode) {
		this.workMode = workMode;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Double getCtc() {
		return ctc;
	}

	public void setCtc(Double ctc) {
		this.ctc = ctc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public JobPosting() {
		// Default constructor is needed by Hibernate
	}

	@Override
	public String toString() {
		return "JobPosting [id=" + id + ", profile=" + profile + ", location=" + location + ", workMode=" + workMode
				+ ", jobType=" + jobType + ", experience=" + experience + ", ctc=" + ctc + ", detail=" + detail
				+ ", user=" + user + "]";
	}

	public JobPosting(Long id, String profile, String location, String workMode, String jobType, String experience,
			Double ctc, String detail, User user) {
		super();
		this.id = id;
		this.profile = profile;
		this.location = location;
		this.workMode = workMode;
		this.jobType = jobType;
		this.experience = experience;
		this.ctc = ctc;
		this.detail = detail;
		this.user = user;
	}
	
	

	// Constructors, getters, setters, and other methods

}
