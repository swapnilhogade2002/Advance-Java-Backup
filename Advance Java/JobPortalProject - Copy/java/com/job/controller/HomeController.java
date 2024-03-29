package com.job.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.job.entity.JobPosting;
import com.job.entity.User;
import com.job.service.JobPostingService;
import com.job.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	private final JobPostingService jobPostingService;

	@RequestMapping("/")
	public String index(Model model) {
		List<JobPosting> jobPostings = jobPostingService.getAllJobPostings();
		model.addAttribute("jobPostings", jobPostings);
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping("/job-list")
	public String jobList() {
		return "job-list";
	}

//	returning jop-list page & showing job on UI
	public HomeController(JobPostingService jobPostingService) {
		this.jobPostingService = jobPostingService;
	}

	@GetMapping("/job-list")
	public String showJobList(Model model) {
		List<JobPosting> jobPostings = jobPostingService.getAllJobPostings();
		model.addAttribute("jobPostings", jobPostings);
		return "job-list";
	}

	@RequestMapping("/job-detail")
	public String jobDetail(Model model) {
		List<JobPosting> jobPostings = jobPostingService.getAllJobPostings(); // Replace with your actual service method
		model.addAttribute("jobPostings", jobPostings);
		return "job-detail";
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "login-page";
	}

	@RequestMapping("/login?logout")
	public String logoutSuccess(Model model) {
		model.addAttribute("logout", true);
		return "login";
	}

	@RequestMapping("/testimonial")
	public String testmonial() {
		return "testimonial";
	}

	@RequestMapping("/category")
	public String category() {
		return "category";
	}

	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}

	@RequestMapping("/404")
	public String error() {
		return "404";
	}
	
	

//	register
//	saving user data
	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user, Model model, @RequestParam("resume") MultipartFile file) {
		try {
			// storing file
			user.setFile(file.getOriginalFilename());
			File saveFile = new ClassPathResource("static/img").getFile();

			Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + file.getOriginalFilename());
			System.out.println("path: "+path);
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("File uploades succesfully!!!");

			userService.saveUser(user);
			model.addAttribute("message", "User saved successfully");

			// Handle the case where file conversion failed
			model.addAttribute("error", "Failed to convert file");

		} catch (IOException e) {
			// Handle the IOException appropriately based on your application's requirements
			e.printStackTrace();
			model.addAttribute("error", "Error processing file");
		}

		return "login-page";
	}
	
	
 
//  Apply for jobs and 
	@PostMapping("/apply")
	public String applyForJob(Model model, @RequestParam("jobId") Long jobId, Principal principal) {
	    // Check if the user is authenticated
	    if (principal == null || principal.getName().equals("anonymousUser")) {
	        // If not authenticated, redirect to the login page
	        return "redirect:/login";
	    }

	    // Get the current user
	    String currentPrincipalName = principal.getName();

	    // Fetch the job details by jobId
	    JobPosting job = jobPostingService.getJobById(jobId);

	    // Add the user and job details to the model (for displaying on the console or processing as needed)
	    model.addAttribute("currentUser", currentPrincipalName);
	    model.addAttribute("job", job);

	    // Log the details to the console for testing
	    System.out.println("Current User: " + currentPrincipalName);
	    System.out.println("Applied Job: " + job.getProfile());

	    // Add your logic for applying to the job (e.g., saving the application to the database)

	    // Redirect to a confirmation page or handle it as needed
	    return "redirect:/user/dashboard";
	}


}
