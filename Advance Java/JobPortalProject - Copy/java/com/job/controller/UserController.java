package com.job.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.job.entity.JobApplications;
import com.job.entity.JobPosting;
import com.job.entity.User;
import com.job.repository.JobApplicationRepository;
import com.job.repository.UserRepository;
import com.job.service.JobPostingService;
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
	private JobApplicationRepository jobApplicationRepository;

	@GetMapping("/dashboard")
	public String userDashboard(Model model) {
		List<JobPosting> jobPostings = jobPostingService.getAllJobPostings();
		model.addAttribute("jobPostings", jobPostings);
		return "user/user-dashboard";
	}
	
	
	@PostMapping("/apply")
	public String applyForJob(@RequestParam("jobId") Long jobId, Model model, Principal principal) {
	    if (principal != null) {
	        String currentUserEmail = principal.getName();

	        // Get the currently logged-in user by email
	        User currentUser = userService.findByEmail(currentUserEmail);

	        if (currentUser != null) {
	            System.out.println("Retrieve job information by job ID");
	            // Retrieve job information by job ID
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




}
