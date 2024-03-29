package com.job.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.job.entity.Feedback;
import com.job.entity.JobPosting;
import com.job.entity.User;
import com.job.repository.FeedbackRepository;
import com.job.service.JobPostingService;
import com.job.service.UserService;

@Controller

@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private UserService userService;
	@Autowired
	private JobPostingService jobPostingService;

	@Autowired
	private FeedbackRepository feedbackRepository;

	@GetMapping("/dashboard")
	public String managerDashboard(Model model, Principal principal) {

		String loggedInUsername = principal.getName();

		List<User> allUsers = userService.getAllUsers();

		// Filter out the logged-in user
		List<User> users = allUsers.stream().filter(user -> !user.getEmail().equals(loggedInUsername))
				.collect(Collectors.toList());

		// Count the number of users
		long userCount = users.stream().filter(user -> user.getRole().equals("ROLE_USER")).count();

		// Count the number of companies
		long companyCount = users.stream().filter(user -> user.getRole().equals("ROLE_COMPANY")).count();

		// Total number of users
		long totalUserCount = users.size();

		model.addAttribute("users", users);
		model.addAttribute("userCount", userCount);
		System.out.println(userCount);
		model.addAttribute("companyCount", companyCount);
		System.out.println(companyCount);
		model.addAttribute("totalUserCount", totalUserCount);
		System.out.println(totalUserCount);

//		other things count
		Long HumanResource = jobPostingService.countJobPostingsInHumanResourceCategory();
		model.addAttribute("HumanResource", HumanResource);

		Long BussinessDevelopment = jobPostingService.countByJobCategoryBussinessDevelopment();
		model.addAttribute("BussinessDevelopment", BussinessDevelopment);

		Long CustomeService = jobPostingService.countByJobCategoryCustomeService();
		model.addAttribute("CustomeService", CustomeService);

		Long DesignAndCreative = jobPostingService.countByJobCategoryDesignAndCreative();
		model.addAttribute("DesignAndCreative", DesignAndCreative);

		Long Marketing = jobPostingService.countByJobCategoryMarketing();
		model.addAttribute("Marketing", Marketing);

		Long ProjectManagement = jobPostingService.countByJobCategoryProjectManagement();
		model.addAttribute("ProjectManagement", ProjectManagement);

		Long SalesAndCommunication = jobPostingService.countByJobCategorySalesAndCommunication();
		model.addAttribute("SalesAndCommunication", SalesAndCommunication);

		Long TeachingAndEducation = jobPostingService.countByJobCategoryTeachingAndEducation();
		model.addAttribute("TeachingAndEducation", TeachingAndEducation);

		return "manager/manager";
	}

//	view user data functionality-Admin
//	@GetMapping("/users-data")
//	public String getUsers(Model model, Principal principal) {
//	
//		String loggedInUsername = principal.getName();
//
//		List<User> allUsers = userService.getAllUsers();
//
//		List<User> users = allUsers.stream().filter(user -> !user.getEmail().equals(loggedInUsername))
//				.collect(Collectors.toList());
//
//		model.addAttribute("users", users);
//
//		return "/manager/users-data";
//	}

//	with pagination
//	@GetMapping("/users-data/{page}")
//	public String getUsers(@PathVariable("page") Integer page, Model model, Principal principal) {
//	    String loggedInUsername = principal.getName();
//
//	    Pageable pageable = PageRequest.of(page, 3); // 3 users per page
//
//	    Page<User> allUsersPage = userService.getAllUsersPage(pageable);
//
//	    // Filter out the logged-in user
//	    List<User> users = allUsersPage.getContent().stream()
//	            .filter(user -> !user.getEmail().equals(loggedInUsername))
//	            .collect(Collectors.toList());
//
//	    // Count the number of users
//	    long userCount = users.stream().filter(user -> user.getRole().equals("ROLE_USER")).count();
//
//	    // Count the number of companies
//	    long companyCount = users.stream().filter(user -> user.getRole().equals("ROLE_COMPANY")).count();
//
//	    // Total number of users
//	    long totalUserCount = allUsersPage.getTotalElements();
//
//	    model.addAttribute("users", users);
//	    model.addAttribute("userCount", userCount);
//	    model.addAttribute("companyCount", companyCount);
//	    model.addAttribute("totalUserCount", totalUserCount);
//	    model.addAttribute("currentPage", page);
//	    model.addAttribute("totalPages", allUsersPage.getTotalPages());
//
//	    return "/manager/users-data";
//	}
//


//	normal code working withoute pagination

	@GetMapping("/users-data")
	public String getUsers(Model model, Principal principal) {
		String loggedInUsername = principal.getName();

		List<User> allUsers = userService.getAllUsers();

		// Filter out the logged-in user
		List<User> users = allUsers.stream().filter(user -> !user.getEmail().equals(loggedInUsername))
				.collect(Collectors.toList());

		// Count the number of users
		long userCount = users.stream().filter(user -> user.getRole().equals("ROLE_USER")).count();

		// Count the number of companies
		long companyCount = users.stream().filter(user -> user.getRole().equals("ROLE_COMPANY")).count();

		// Total number of users
		long totalUserCount = users.size();

		model.addAttribute("users", users);
		
//		count
		model.addAttribute("userCount", userCount);
		System.out.println(userCount);
		model.addAttribute("companyCount", companyCount);
		System.out.println(companyCount);
		model.addAttribute("totalUserCount", totalUserCount);
		System.out.println(totalUserCount);

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
		user.setPassword("Nashik@123");

		userService.saveUser(user);

		return "redirect:/manager/users-data";
	}

//	feedback
// with pagination
	@GetMapping("/show-feedback/{page}")
	public String showFeedback(@PathVariable("page") Integer page, Model model) {
		Pageable pageable = PageRequest.of(page, 3); // 3 feedback items per page

		Page<Feedback> feedbackPage = feedbackRepository.findAll(pageable);
		List<Feedback> feedbackList = feedbackPage.getContent(); // Extract content from the page

		model.addAttribute("feedbackList", feedbackList);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", feedbackPage.getTotalPages());
		return "/manager/feedback";
	}

//	@GetMapping("/show-feedback")
//	public String showFeedback(Model model) {
//		List<Feedback> feedbackList = feedbackRepository.findAll();
//		model.addAttribute("feedbackList", feedbackList);
//		return "/manager/feedback";
//	}

}
