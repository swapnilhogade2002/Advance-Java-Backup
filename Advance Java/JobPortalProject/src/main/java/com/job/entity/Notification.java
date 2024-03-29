package com.job.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String message;

	@ManyToOne(fetch = FetchType.LAZY) // Assuming lazy loading is acceptable
	@JoinColumn(name = "job_id")
	private JobPosting jobPosting;

	@ManyToOne
	@JoinColumn(name = "recipient_id")
	private User recipient;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private User company;

	private boolean status;

	private boolean accepted;

	// Constructors, getters, and setters
	public Long getId() {
		return id;
	}

	public User getCompany() {
		return company;
	}

	public void setCompany(User company) {
		this.company = company;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Notification(Long id, String message, User recipient, boolean status) {
		super();
		this.id = id;
		this.message = message;
		this.recipient = recipient;
		this.status = status;
	}

	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public void setJobPosting(JobPosting jobPosting) {
	    this.jobPosting = jobPosting;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", message=" + message + ", jobPosting=" + jobPosting + ", recipient="
				+ recipient + ", company=" + company + ", status=" + status + ", accepted=" + accepted + "]";
	}
	
	
	
	


}