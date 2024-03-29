package com.job.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_applications")
public class JobApplications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobPosting jobPosting;
    
    @Column(name = "accepted")
    private boolean accepted; // New field to indicate if the job application is accepted
    
    // Other fields, getters, and setters

    public Long getId() {
        return id;
    }

    public JobApplications() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobApplications(Long id, User user, JobPosting jobPosting, boolean accepted) {
		super();
		this.id = id;
		this.user = user;
		this.jobPosting = jobPosting;
		this.accepted = accepted;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }



}
