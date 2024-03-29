package com.job.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.job.entity.Feedback;
import com.job.entity.JobPosting;
import com.job.entity.Notification;
import com.job.entity.User;
import com.job.repository.FeedbackRepository;
import com.job.repository.JobApplicationRepository;
import com.job.repository.JobPostingRepository;
import com.job.repository.NotificationRepo;
import com.job.repository.UserRepository;
import com.job.service.JobApplicationService;
import com.job.service.JobPostingService;
import com.job.service.NotificationService;
import com.job.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private JobPostingRepository JobPostingRepository;

	private final JobPostingService jobPostingService;

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JobApplicationRepository jobApplicationRepository;

	@Autowired
	private NotificationRepo notificationRepository;

	@Autowired
	private JobApplicationService jobApplicationService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private FeedbackRepository feedbackRepository;

	@RequestMapping("/")
	public String index(Model model) {

//	all jobs view	- sorting
		List<JobPosting> jobPostings = jobPostingService.getAllJobPostings();
		model.addAttribute("jobPostings", jobPostings);

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

// jobs - category count
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

		return "index";
	}

//	@GetMapping("/{page}")
//	public String index(Model model, @PathVariable("page") int page) {
//		int pageSize = 10; // Adjust the page size as needed
//		Page<JobPosting> jobPostingsPage = jobPostingService.getAllJobPostings(PageRequest.of(page - 1, pageSize)); // Adjusting
//																													// page
//																													// to
//																													// start
//																													// from
//																													// 0
//		List<JobPosting> jobPostings = jobPostingsPage.getContent();
//
//		model.addAttribute("jobPostings", jobPostings);
//		model.addAttribute("currentPage", page - 1); // Adjusting currentPage to start from 0
//		model.addAttribute("totalPages", jobPostingsPage.getTotalPages());
//
//		return "index"; // Assuming your view is named "index.html"
//	}

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
			System.out.println("path: " + path);
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

		// Add the user and job details to the model (for displaying on the console or
		// processing as needed)
		model.addAttribute("currentUser", currentPrincipalName);
		model.addAttribute("job", job);

		// Log the details to the console for testing
		System.out.println("Current User: " + currentPrincipalName);
		System.out.println("Applied Job: " + job.getProfile());

		// Add your logic for applying to the job (e.g., saving the application to the
		// database)

		// Redirect to a confirmation page or handle it as needed
		return "redirect:/user/dashboard";
	}

//	forgot password 

//	forgot password 
	@GetMapping("/forgot-password")
	public String forgotPasswordForm() {
		return "forgot-password";
	}

//	@PostMapping("/forgot-password")
//	public String forgotPassword(@RequestParam("email") String email,
//	                             @RequestParam("newPassword") String newPassword,
//	                             @RequestParam("confirmPassword") String confirmPassword) {
//	    // Check if the passwords match
//	    if (!newPassword.equals(confirmPassword)) {
//	        // Redirect back to the forgot-password page with an error message
//	        return "redirect:/forgot-password?error=passwordMismatch";
//	    }
//
//	    // Find the user by email
//	    User user = userRepository.findByEmail(email);
//	    if (user == null) {
//	        // Redirect back to the forgot-password page with an error message
//	        return "redirect:/forgot-password?error=userNotFound";
//	    }
//
//	    // Update the user's password with the new password
//	    user.setPassword(passwordEncoder.encode(newPassword));
//	    userRepository.save(user);
//
//	    // Redirect to the login page with a success message
//	    return "redirect:/login?resetSuccess";
//	}

	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestParam("email") String email, @RequestParam("newPassword") String newPassword,
			@RequestParam("confirmPassword") String confirmPassword, RedirectAttributes redirectAttributes) {
		// Check if the passwords match
		if (!newPassword.equals(confirmPassword)) {
			// Redirect back to the forgot-password page with an error message
			redirectAttributes.addAttribute("error", "Something went wrong");
			return "redirect:/forgot-password";
		}

		// Find the user by email
		User user = userRepository.findByEmail(email);
		if (user == null) {
			// Redirect back to the forgot-password page with an error message
			redirectAttributes.addAttribute("error", "userNotFound");
			return "redirect:/forgot-password";
		}

		// Update the user's password with the new password
		user.setPassword(passwordEncoder.encode(newPassword));
		userRepository.save(user);

		// Add success message to URL parameters
		redirectAttributes.addAttribute("success", "passwordChanged");

		return "redirect:/login?resetSuccess";
	}

//	feedback form
	@GetMapping("/feedback")
	public String getFeedbackForm() {
		return "feedback-form";

	}

	@PostMapping("/submit")
	public String submitFeedback(@RequestParam("fullName") String fullName, @RequestParam("email") String email,
			@RequestParam("feedback") String feedback) {
		Feedback newFeedback = new Feedback();
		newFeedback.setFullName(fullName);
		newFeedback.setEmail(email);
		newFeedback.setFeedback(feedback);
		feedbackRepository.save(newFeedback);
		return "redirect:/";
	}

	@PutMapping("/feedback/updateStatus/{id}")
	public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, Object> payload) {
		Optional<Feedback> feedbackOptional = feedbackRepository.findById(id);
		if (feedbackOptional.isPresent()) {
			Feedback feedback = feedbackOptional.get();
			boolean newStatus = (boolean) payload.get("status");
			feedback.setStatus(newStatus);
			feedbackRepository.save(feedback);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

//	job searching with category

	@Autowired
	private JobPostingRepository jobPostingRepository;

	@GetMapping("/category/{categoryName}")
	public String getJobsByCategory(@PathVariable String categoryName, Model model) {

		// Query the database for job postings related to the given category
		List<JobPosting> jobPostings = jobPostingRepository.findByJobCategory(categoryName);

		// Calculate count of job postings for each category
		Map<String, Long> categoryCounts = jobPostings.stream()
				.collect(Collectors.groupingBy(JobPosting::getJobCategory, Collectors.counting()));

		// Display category count on console
		categoryCounts.forEach((category, count) -> System.out.println(category + ": " + count));

		model.addAttribute("categoryName", categoryName);
		model.addAttribute("jobPostings", jobPostings);
		model.addAttribute("categoryCounts", categoryCounts);

		// Add a specific count attribute for the current category
		model.addAttribute("currentCategoryCount", categoryCounts.getOrDefault(categoryName, 0L));

		// Add counts for all categories
		// Add a specific count attribute for each category, ensuring they are not null
		for (String category : Arrays.asList("Marketing", "Customer Service", "Human Resource", "Project Management",
				"Business Development", "Sales & Communication", "Teaching & Education", "Design & Creative")) {
			model.addAttribute(category + "Count", categoryCounts.getOrDefault(category, 0L));
		}

		return "jobsByCategory"; // Thymeleaf template name
	}

	private void addCategoryCountsToModel(Model model, Map<String, Long> categoryCounts) {
		// Add count for each category to the model
		for (String category : categoryCounts.keySet()) {
			// Add attribute only if the count is not null
			if (categoryCounts.get(category) != null) {
				model.addAttribute(category + "Count", categoryCounts.get(category));
			}
		}
	}
}
//	 @GetMapping("/category/{categoryName}")
//	    public String getJobsByCategory(@PathVariable String categoryName, Model model) {
//	        // Query the database for job postings related to the given category
//	        List<JobPosting> jobPostings = JobPostingRepository.findByJobCategory(categoryName);
//
//	        model.addAttribute("jobPostings", jobPostings);
//	        return "jobsByCategory"; // Thymeleaf template name
//	    }
