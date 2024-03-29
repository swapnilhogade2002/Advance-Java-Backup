package com.job.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.job.entity.JobApplications;
import com.job.entity.JobPosting;
import com.job.entity.User;
import com.job.repository.JobApplicationRepository;
import com.job.repository.JobPostingRepository;

@Service
public class JobApplicationService {
	private final JobApplicationRepository jobApplicationsRepository;

	@Autowired
	private JobApplicationRepository jobApplicationRepository;

	@Autowired
	private JobPostingRepository jobPostingRepository;

	@Autowired
	public JobApplicationService(JobApplicationRepository jobApplicationsRepository) {
		this.jobApplicationsRepository = jobApplicationsRepository;
	}

	public List<JobApplications> getApplicationsByJobPosting(JobPosting jobPosting) {
		return jobApplicationsRepository.findByJobPosting(jobPosting);
	}

//	public List<JobApplications> getApplicationsByJobPosting(JobPosting jobPosting) {
//		return jobApplicationsRepository.findByJobPosting(jobPosting.getId());
//	}

	// Define method to update status to accepted
	public void updateStatusToAccepted(Long userId) {
		// Logic to update status to accepted
		// Assuming you have a method in your repository to update the status
		// jobApplicationsRepository.updateStatusToAccepted(userId);
	}

	// Method to delete job application
	public void updateJobApplicationStatus(Long jobId, boolean status) {
		// Fetch the job application from the database using jobId
		Optional<JobApplications> optionalJobApplication = jobApplicationRepository.findById(jobId);

		// If the job application exists, update its status and save it back to the
		// database
		optionalJobApplication.ifPresent(jobApplications -> {
			jobApplications.setAccepted(status);
			jobApplicationRepository.save(jobApplications);
		});
	}

	public Page<JobApplications> findByJobPosting(JobPosting jobPosting, Pageable pageable) {
		return jobApplicationRepository.findByJobPosting(jobPosting, pageable);
	}

	public int getTotalJobApplicationsForCompany(User loggedInCompany) {
		// Retrieve job postings created by the logged-in company
		List<JobPosting> companyJobPostings = jobPostingRepository.findByUserId(loggedInCompany.getId());

		// Initialize a variable to store the total number of job applications
		int totalJobApplications = 0;

		// Iterate over each job posting
		for (JobPosting posting : companyJobPostings) {
			// Retrieve the count of job applications for the current job posting
			long jobApplicationsCount = jobApplicationRepository.countByJobPosting(posting);

			// Add the count to the total number of job applications
			totalJobApplications += jobApplicationsCount;
		}

		return totalJobApplications;
	}

}
