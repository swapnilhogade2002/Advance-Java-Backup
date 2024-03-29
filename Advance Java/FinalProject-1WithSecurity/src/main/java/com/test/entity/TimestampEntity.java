package com.test.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TimestampEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userId;
	private LocalDateTime punchInTime;
	private LocalDateTime punchOutTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public LocalDateTime getPunchInTime() {
		return punchInTime;
	}
	public void setPunchInTime(LocalDateTime punchInTime) {
		this.punchInTime = punchInTime;
	}
	public LocalDateTime getPunchOutTime() {
		return punchOutTime;
	}
	public void setPunchOutTime(LocalDateTime punchOutTime) {
		this.punchOutTime = punchOutTime;
	}

}

