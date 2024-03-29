package com.job.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.job.entity.JobApplications;
import com.job.entity.JobPosting;
import com.job.entity.Notification;
import com.job.entity.User;
import com.job.repository.JobApplicationRepository;
import com.job.repository.JobPostingRepository;
import com.job.repository.NotificationRepo;
import com.job.repository.UserRepository;
import com.job.service.JobPostingService;
import com.job.service.NotificationService;
import com.job.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private JobPostingService jobPostingService;

	@Autowired
	private JobApplicationRepository jobApplicationRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private JobPostingRepository jobPostingRepository;

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private NotificationRepo notificationRepo;

//  Company dashboard
	@GetMapping("/dashboard")
	public String companyDashboardView(Model model, Principal principal) {
		if (principal != null) {
			String currentUserEmail = principal.getName();

			// Get the currently logged-in user by email
			User currentUser = userService.findByEmail(currentUserEmail);

			if (currentUser != null) {
				// Get jobs posted by the current user
				List<JobPosting> userJobs = jobPostingService.getJobsByUser(currentUser.getId());

				// Count the total number of jobs posted by the user
				long totalJobsPosted = userJobs.size();

				// Count the number of jobs based on work mode
				long workFromHomeJobs = userJobs.stream()
						.filter(job -> "work from home".equalsIgnoreCase(job.getWorkMode())).count();
				long workFromOfficeJobs = userJobs.stream()
						.filter(job -> "work from office".equalsIgnoreCase(job.getWorkMode())).count();

				// Add userJobs to the model for rendering in Thymeleaf template
				model.addAttribute("currentUser", currentUser);
				model.addAttribute("userJobs", userJobs);
				model.addAttribute("totalJobsPosted", totalJobsPosted);
				model.addAttribute("workFromHomeJobs", workFromHomeJobs);
				model.addAttribute("workFromOfficeJobs", workFromOfficeJobs);

				// Print user details to the console
				System.out.println("User Details:");
				System.out.println("Email: " + currentUser.getEmail());
				System.out.println("Total Jobs Posted: " + totalJobsPosted);
				System.out.println("Work from Home Jobs: " + workFromHomeJobs);
				System.out.println("Work from Office Jobs: " + workFromOfficeJobs);

				// Return the Thymeleaf template path
				return "/company/company";
			}
		}

		// Handle the case where the principal is null or the user is not found
		return "redirect:/login"; // You can redirect to the login page or handle it according to your needs
	}

	// Add-job form
	@GetMapping("/add-job")
	public String addJob() {
		return "company/jobPostForm";
	}

//	Save job with mapping 
	@PostMapping("/save")
	public String saveJobPosting(@ModelAttribute JobPosting jobPosting, Principal principal, Model model) {
		try {
			// Get the currently logged-in user
			User loggedInUser = userService.findByEmail(principal.getName()); // Assuming you have a userService

			// Set the user in the jobPosting
			jobPosting.setUser(loggedInUser);

			// Save the job posting
			JobPosting savedJobPosting = jobPostingService.saveJobPosting(jobPosting);

			// Redirect to the dashboard view
			return "redirect:/company/dashboard";
		} catch (Exception e) {
			// Handle the error, you might want to display an error message on the current
			// page
			model.addAttribute("errorMessage", "Error saving job posting: " + e.getMessage());
			return "error-page"; // Replace "error-page" with the actual error page view name
		}
	}

//	showing all jobs to company
	@GetMapping("/view-jobs")
	public String viewJobs(Model model, Principal principal) {
		if (principal != null) {
			String currentUserEmail = principal.getName();

			// Get the currently logged-in user by email
			User currentUser = userService.findByEmail(currentUserEmail);

			if (currentUser != null) {
				// Get jobs posted by the current user
				List<JobPosting> userJobs = jobPostingService.getJobsByUser(currentUser.getId());

				// Add userJobs to the model for rendering in Thymeleaf template
				model.addAttribute("userJobs", userJobs);

				// Return the Thymeleaf template path
				return "/company/view-jobs";
			}
		}

		// Handle the case where the principal is null or the user is not found
		return "redirect:/login"; // You can redirect to the login page or handle it according to your needs
	}

//	showing company profile
	@GetMapping("/profile")
	public String showProfile(Model model, Principal principal) {
		if (principal != null) {
			String currentUserEmail = principal.getName();

			// Get the currently logged-in user by email
			User currentUser = userService.findByEmail(currentUserEmail);

			if (currentUser != null) {
				// Get jobs posted by the current user
				List<JobPosting> userJobs = jobPostingService.getJobsByUser(currentUser.getId());

				// Count the total number of jobs posted by the user
				long totalJobsPosted = userJobs.size();

				// Count the number of jobs based on work mode
				long workFromHomeJobs = userJobs.stream()
						.filter(job -> "work from home".equalsIgnoreCase(job.getWorkMode())).count();
				long workFromOfficeJobs = userJobs.stream()
						.filter(job -> "work from office".equalsIgnoreCase(job.getWorkMode())).count();

				// Add userJobs to the model for rendering in Thymeleaf template
				model.addAttribute("currentUser", currentUser);
				model.addAttribute("userJobs", userJobs);
				model.addAttribute("totalJobsPosted", totalJobsPosted);
				model.addAttribute("workFromHomeJobs", workFromHomeJobs);
				model.addAttribute("workFromOfficeJobs", workFromOfficeJobs);

				// Return the Thymeleaf template path
				return "/company/company-profile";
			}
		}

		// Handle the case where the principal is null or the user is not found
		return "redirect:/login"; // You can redirect to the login page or handle it according to your needs
	}

//	calculate total for dashboard
	@GetMapping("/count")
	public String companyDashboard(Model model, Principal principal) {
		if (principal != null) {
			String currentUserEmail = principal.getName();

			// Get the currently logged-in user by email
			User currentUser = userService.findByEmail(currentUserEmail);

			if (currentUser != null) {
				// Get jobs posted by the current user
				List<JobPosting> userJobs = jobPostingService.getJobsByUser(currentUser.getId());

				// Count the total number of jobs posted by the user
				long totalJobsPosted = userJobs.size();

				// Count the number of jobs based on work mode
				long workFromHomeJobs = userJobs.stream()
						.filter(job -> "work from home".equalsIgnoreCase(job.getWorkMode())).count();
				long workFromOfficeJobs = userJobs.stream()
						.filter(job -> "work from office".equalsIgnoreCase(job.getWorkMode())).count();

				// Add counts to the model for rendering in Thymeleaf template
				model.addAttribute("currentUser", currentUser);
				model.addAttribute("totalJobsPosted", totalJobsPosted);
				model.addAttribute("workFromHomeJobs", workFromHomeJobs);
				model.addAttribute("workFromOfficeJobs", workFromOfficeJobs);

				// Print counts to the console
				System.out.println("User Details:");
				System.out.println("Email: " + currentUser.getEmail());
				System.out.println("Total Jobs Posted: " + totalJobsPosted);
				System.out.println("Work from Home Jobs: " + workFromHomeJobs);
				System.out.println("Work from Office Jobs: " + workFromOfficeJobs);

				// Return the Thymeleaf template path
				return "company/dashboard";
			}
		}

		// Handle the case where the principal is null or the user is not found
		return "redirect:/login"; // You can redirect to the login page or handle it according to your needs
	}

//	application of jobs
	@GetMapping("/job-application")
	public String jobApplication(Model model, Principal principal) {
		// Retrieve the logged-in company
		String loggedInUsername = principal.getName();
		User loggedInCompany = userRepository.findByEmail(loggedInUsername);

		// Retrieve job postings created by the logged-in company
		List<JobPosting> companyJobPostings = jobPostingRepository.findByUserId(loggedInCompany.getId());

		// Retrieve job applications associated with the company's job postings
		List<JobApplications> jobApplicationsList = new ArrayList<>();
		for (JobPosting posting : companyJobPostings) {
			jobApplicationsList.addAll(jobApplicationRepository.findByJobPosting(posting));
		}

		// Add the job applications to the model
		model.addAttribute("jobApplications", jobApplicationsList);

		return "/company/job-application";
	}

//	notification job accept-reject

	@PostMapping("/accept-job")
	public String acceptJob(Model model, Principal principal, @RequestParam Long userId) {
	    // Get the recipient user
	    User recipient = userRepository.findById(userId)
	            .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));

	    // Create a new notification
	    Notification notification = new Notification();
	    notification.setMessage("You are selected for the job!");
	    notification.setRecipient(recipient);
	    notification.setStatus(false); // Assuming initial status is unread

	    // Save the notification
	    notificationRepo.save(notification);

	    // Optionally, mark notifications as read if necessary
	    List<Notification> notifications = notificationRepo.findByRecipientAndStatus(recipient, false);
	    for (Notification notif : notifications) {
	        notif.setStatus(true); // Mark as read
	        notificationRepo.save(notif);
	    }

	    // Redirect to the appropriate page
	    return "redirect:/company/job-applications";
	}




// CRUD of jobs	
	// Controller method for displaying the edit job form
	@GetMapping("/edit-job/{id}")
	public String editJob(@PathVariable Long id, Model model) {
		JobPosting job = jobPostingService.getJobById(id);
		model.addAttribute("job", job);
		return "/company/edit-job";
	}

// Controller method for updating the job details

	@PostMapping("/edit-job/{id}")
	public String updateJob(@PathVariable Long id, @ModelAttribute JobPosting updatedJob) {
		// Retrieve the existing job by ID
		JobPosting existingJob = jobPostingService.getJobById(id);

		// Update the existing job details with the new values
		existingJob.setProfile(updatedJob.getProfile());
		existingJob.setLocation(updatedJob.getLocation());
		existingJob.setWorkMode(updatedJob.getWorkMode());
		existingJob.setJobType(updatedJob.getJobType());
		existingJob.setExperience(updatedJob.getExperience());
		existingJob.setCtc(updatedJob.getCtc());
		existingJob.setDetail(updatedJob.getDetail());

		// Save the updated job details
		jobPostingService.saveJob(existingJob);

		// Redirect to a suitable endpoint (e.g., job details page)
		return "redirect:/company/view-jobs";
	}

//	@PostMapping("/edit-job/{id}")
//	public String updateJob(@PathVariable Long id, @ModelAttribute JobPosting updatedJob) {
//		jobPostingService.updateJob(id, updatedJob);
//		return "redirect:/company/view-jobs";
//	}

	// Controller method for handling job deletion
	@PostMapping("/delete-job/{id}")
	public String deleteJob(@PathVariable Long id) {
		jobPostingService.deleteJob(id);
		return "redirect:/company/view-jobs";
	}

}
