package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Admin findByUserName(String userName);
}
