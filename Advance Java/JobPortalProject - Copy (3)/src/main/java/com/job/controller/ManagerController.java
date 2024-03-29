package com.job.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.job.entity.JobPosting;
import com.job.entity.User;
import com.job.service.JobPostingService;
import com.job.service.UserService;

@Controller

@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private UserService userService;
	@Autowired
	private JobPostingService jobPostingService;

	@GetMapping("/dashboard")
	public String managerDashboard() {
		return "manager/manager";
	}

//	view user data functionality-Admin
	@GetMapping("/users-data")
	public String getUsers(Model model, Principal principal) {
		// Retrieve the currently logged-in user's username
		String loggedInUsername = principal.getName();

		// Get all users from the service
		List<User> allUsers = userService.getAllUsers();

		// Filter out the currently logged-in user's data
		List<User> users = allUsers.stream().filter(user -> !user.getEmail().equals(loggedInUsername))
				.collect(Collectors.toList());

		// Add the filtered users to the model
		model.addAttribute("users", users);

		// Return the view
		return "/manager/users-data";
	}

//	edit user data functionality-Admin
	@GetMapping("/edit/{userId}")
	public String editUserForm(@PathVariable("userId") Long userId, Model model) {
		User user = userService.getUserById(userId);
		model.addAttribute("user", user);

		return "/manager/edit-user";
	}

	@PostMapping("/edit/{userId}")
	public String updateUser(@PathVariable("userId") Long userId, @ModelAttribute("user") User updatedUser) {
		User user = userService.getUserById(userId);

		user.setName(updatedUser.getName());
		user.setEmail(updatedUser.getEmail());
		user.setMobile(updatedUser.getMobile());
		user.setWork(updatedUser.getWork());
		user.setCity(updatedUser.getCity());

		userService.saveUser(user);

		return "redirect:/manager/users-data";
	}

//	delete user data functionality-Admin
//	@RequestMapping("/delete/{userId}")
//	public String deleteUser(@PathVariable("userId") Long userId, RedirectAttributes redirectAttributes) {
//		try {
//			System.out.println("In delete functionality");
//			userService.deleteUserById(userId);
//			System.out.println("User deleted");
//			redirectAttributes.addFlashAttribute("successMessage", "User deleted successfully");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("errorMessage", "Error deleting user: " + e.getMessage());
//		}
//		return "redirect:/manager/users-data"; // Redirect to a page where users are listed
//	}

	
}
