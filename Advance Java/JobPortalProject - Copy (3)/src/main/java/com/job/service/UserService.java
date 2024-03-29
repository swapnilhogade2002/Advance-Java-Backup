package com.job.service;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.job.entity.User;
import com.job.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

//	saving user data
	public User saveUser(User user) {

		String password = passwordEncoder.encode(user.getPassword());

		user.setPassword(password);
		return userRepository.save(user);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User getUserById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public byte[] getUserResumeData(Long userId) throws Exception {
		// Retrieve the user entity from the database based on userId
		User user = userRepository.findById(userId).orElse(null);

		if (user != null) {
			// Assuming the resume data is stored as a file path in the User entity
			String filePath = user.getFile(); // Adjust this based on your entity structure

			// Load file content from the specified path
			File file = ResourceUtils.getFile(filePath);
			if (file.exists()) {
				return Files.readAllBytes(file.toPath());
			} else {
				throw new IOException("File not found: " + filePath);
			}
		} else {
			// Handle case where user is not found
			throw new Exception("User not found with ID: " + userId);
		}
	}

//	view user data functionality- Admin

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Transactional
	public void deleteUserById(Long userId) {
		// Check if the user exists
		User user = userRepository.findById(userId).orElse(null);
		if (user != null) {
			// Remove the user from any associated entities (if needed)
			// For example, you may want to delete related job postings
			user.getJobPostings().clear();
			// Delete the user
			userRepository.delete(user);
		}
	}

}
