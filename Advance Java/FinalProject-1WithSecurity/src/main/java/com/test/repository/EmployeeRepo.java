package com.test.repository;

import com.test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	public Employee findByEmail(String email);

	@Query("select e from Employee e where e.email = :email")
	public Employee getEmployeeByName(@Param("email") String email);

	public boolean existsByEmail(String email);
}