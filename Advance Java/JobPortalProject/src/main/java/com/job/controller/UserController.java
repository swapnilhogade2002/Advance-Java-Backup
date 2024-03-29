package com.job.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.job.entity.JobApplications;
import com.job.entity.JobPosting;
import com.job.entity.Notification;
import com.job.entity.User;
import com.job.repository.JobApplicationRepository;
import com.job.repository.NotificationRepo;
import com.job.repository.UserRepository;
import com.job.service.JobApplicationService;
import com.job.service.JobPostingService;
import com.job.service.NotificationService;
import com.job.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private JobPostingService jobPostingService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private JobApplicationRepository jobApplicationRepository;

	@Autowired
	private NotificationRepo notificationRepository;

	@Autowired
	private JobApplicationService jobApplicationService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/dashboard")
	public String userDashboard(Model model) {
		List<JobPosting> jobPostings = jobPostingService.getAllJobPostings();
		model.addAttribute("jobPostings", jobPostings);

//		all jobs view	- sorting

		List<JobPosting> allJobPostingsContract = jobPostingService.getAllJobPostings();
		List<JobPosting> contractJobs = allJobPostingsContract.stream()
				.filter(jobPosting -> "Contract basis".equals(jobPosting.getJobType())).collect(Collectors.toList());
		model.addAttribute("contractJobs", contractJobs);

		List<JobPosting> allJobPostingsFullTime = jobPostingService.getAllJobPostings();
		List<JobPosting> fullTimeJobs = allJobPostingsFullTime.stream()
				.filter(jobPosting -> "Full time".equals(jobPosting.getJobType())).collect(Collectors.toList());
		model.addAttribute("fullTimeJobs", fullTimeJobs);

		List<JobPosting> allJobPostingsPartTime = jobPostingService.getAllJobPostings();
		List<JobPosting> partTimeJobs = allJobPostingsFullTime.stream()
				.filter(jobPosting -> "Part time".equals(jobPosting.getJobType())).collect(Collectors.toList());
		model.addAttribute("partTimeJobs", partTimeJobs);

		List<JobPosting> allJobPostingsTemporory = jobPostingService.getAllJobPostings();
		List<JobPosting> Temporary = allJobPostingsFullTime.stream()
				.filter(jobPosting -> "Temporary".equals(jobPosting.getJobType())).collect(Collectors.toList());
		model.addAttribute("Temporary", Temporary);

		return "user/user-dashboard";
	}

//	apply for new job
	@PostMapping("/apply")
	public String applyForJob(@RequestParam("jobId") Long jobId, Model model, Principal principal) {
		if (principal != null) {
			String currentUserEmail = principal.getName();

			// Get the currently logged-in user by email
			User currentUser = userService.findByEmail(currentUserEmail);

			if (currentUser != null) {
				System.out.println("Retrieve job information by job ID");

				JobPosting jobPosting = jobPostingService.getJobById(jobId);

				// Check if jobPosting is null or not
				if (jobPosting != null) {
					// Check if the current user has already applied for the same job
					boolean hasApplied = jobApplicationRepository.existsByUserAndJobPosting(currentUser, jobPosting);

					// Ensure the condition is rechecked after reapplying for the job
					if (!hasApplied) {
						System.out.println("Checking if the user has already applied for the job.");
						// Create a new JobApplication entity
						JobApplications jobApplication = new JobApplications();
						jobApplication.setUser(currentUser);
						jobApplication.setJobPosting(jobPosting);

						// Save the job application to the database
						jobApplicationRepository.save(jobApplication);

						// Set a success message
						model.addAttribute("message", "You have successfully applied for this job.");

						// Return the Thymeleaf template path for displaying the information
						return "user/user-dashboard"; // Or any other desired page
					} else {
						// User has already applied for the same job, set a message
						model.addAttribute("message", "You have already applied for this job.");
						return "user/user-dashboard";
					}
				} else {
					// Handle the case where jobPosting is null
					model.addAttribute("message", "Job details not found.");
				}
			}
		}

		// Handle the case where the principal is null or the user is not found
		return "redirect:/login";
	}

//	user job notification
//	@GetMapping("/notification")
//	public String getNotifications(Model model) {
//		List<Notification> jobNotification = notificationService.getAllJobNotification();
//		System.out.println(jobNotification);
//		model.addAttribute("jobNotification", jobNotification);
//		return "user/job-notification";
//	}

	@GetMapping("/notification")
	public String getNotifications(Model model, Principal principal) {
		if (principal == null) {
			// User is not authenticated, handle the situation accordingly
			// For example, redirect to a login page or display an error message
			return "redirect:/login"; // Redirect to the login page
		}

		String username = principal.getName();

		// Retrieve the authenticated user from the database based on the username
		User user = userService.findByEmail(username); // Assuming userService has a method to find a user by email

		Long userId = user.getId();

		// Retrieve notifications for the logged-in user
		List<Notification> userNotifications = notificationService.getAllJobNotificationForUser(userId);

		// Print the notifications for debugging purposes
		System.out.println("Notifications for user with ID " + userId + ":");
		for (Notification notification : userNotifications) {
			System.out.println(notification.getMessage());
		}

		// Add notifications to the model
		model.addAttribute("jobNotification", userNotifications);

		return "user/job-notification";
	}

//	reject job application-delete
//	  @PostMapping("/update-job-application")
//	    public String updateJobApplication(@RequestParam("notificationId") Long notificationId) {
//	        Optional<Notification> notificationOptional = notificationRepository.findById(notificationId);
//	        
//	        if (notificationOptional.isPresent()) {
//	            Notification notification = notificationOptional.get();
//	            notification.setStatus(true);
//	            notification.setAccepted(true);
//	            notificationRepository.save(notification);
//	        }
//	        
//	        // Redirect to a suitable page after updating the notification
//	        return "redirect:/";
//	    }

//	Accept 0/1
//	@PostMapping("/update-job-application")
//	public String updateJobApplication(@RequestParam("notificationId") Long notificationId,
//	                                   @RequestParam(value = "action", required = false) String action,
//	                                   Model model) {
//	    Optional<Notification> notificationOptional = notificationRepository.findById(notificationId);
//
//	    if (notificationOptional.isPresent()) {
//	        Notification notification = notificationOptional.get();
//	        notification.setAccepted("accept".equalsIgnoreCase(action));
//	        
//	        // Set the status based on the action
//	        if ("accept".equalsIgnoreCase(action)) {
//	            notification.setStatus(true); // Set status to true if accepted
//	            model.addAttribute("requestSent", true); // Add attribute to indicate request sent
//	        } else if ("decline".equalsIgnoreCase(action)) {
//	            notification.setStatus(false); // Set status to false if declined
//	        }
//	        
//	        notificationRepository.save(notification);
//	    }
//
//	    // Redirect to a suitable page after updating or deleting the notification
//	    return "redirect:/user/notification";
//	}

//	
	@PostMapping("/update-job-application")
	public String updateJobApplication(@RequestParam("notificationId") Long notificationId,
			@RequestParam(value = "action", required = false) String action, Model model) {
		Optional<Notification> notificationOptional = notificationRepository.findById(notificationId);

		if (notificationOptional.isPresent()) {
			Notification notification = notificationOptional.get();
			notification.setAccepted("accept".equalsIgnoreCase(action));

			// Set the status based on the action
			if ("accept".equalsIgnoreCase(action)) {
				notification.setStatus(true); // Set status to true if accepted
				// Add message to model indicating acceptance
				model.addAttribute("acceptanceMessage", "Thank you! Recruiter will call shortly.");
			} else if ("decline".equalsIgnoreCase(action)) {
				notification.setStatus(false); // Set status to false if declined
				// Add flag to model indicating notification has been declined
				model.addAttribute("notificationDeclined", true);
			}

			notificationRepository.save(notification);
		}

		// Redirect to a suitable page after updating or deleting the notification
		return "redirect:/user/notification";
	}

}
