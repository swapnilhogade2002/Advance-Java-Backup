package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.repository.AdminRepository;
import com.test.entity.Admin;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public boolean verifyAdminLogin(String userName, String password) {
		Admin admin = adminRepository.findByUserName(userName);

		// Log input data
		System.out.println("Input: Username - " + userName + ", Password - " + password);

		// Log whether the user is found
		System.out.println("User found: " + (admin != null));

		if (admin != null && admin.getPassword().equals(password)) {
			return true;
		}

		return false;
	}
}
