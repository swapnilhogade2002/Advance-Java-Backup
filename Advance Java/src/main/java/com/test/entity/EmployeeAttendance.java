package com.test.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeId;

    private LocalDate date;

    private double totalWorkHours;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getTotalWorkHours() {
		return totalWorkHours;
	}

	public void setTotalWorkHours(double totalWorkHours) {
		this.totalWorkHours = totalWorkHours;
	}

	@Override
	public String toString() {
		return "EmployeeAttendance [id=" + id + ", employeeId=" + employeeId + ", date=" + date + ", totalWorkHours="
				+ totalWorkHours + "]";
	}
    
    
}