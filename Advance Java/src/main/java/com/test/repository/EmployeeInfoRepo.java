package com.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.entity.EmployeeInfo;

@Repository
public interface EmployeeInfoRepo extends JpaRepository<EmployeeInfo, Long> {
	// You don't need to declare findById here, it's already provided by
	// JpaRepository
	
//	total count gender-male
	long countByGender(String gender);
	
//	total count married employee
	long countByMaritalStatus(String maritalStatus);
	
//	total count Bachelors degress
	long countByEducationLevel(String educationLevel);

	
	   // Custom query to search employees by keyword
    @Query("SELECT e FROM EmployeeInfo e WHERE " +
           "LOWER(e.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(e.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(e.city) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(e.gender) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(e.maritalStatus) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(e.educationLevel) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(e.salary) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(e.username) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(e.password) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	Page<EmployeeInfo> searchEmployee(@Param("keyword") String keyword, Pageable pageable);
	
	
}