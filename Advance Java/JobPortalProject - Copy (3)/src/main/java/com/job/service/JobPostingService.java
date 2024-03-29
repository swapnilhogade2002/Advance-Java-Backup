package com.job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.job.entity.JobPosting;
import com.job.repository.JobPostingRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class JobPostingService {

	@Autowired
	private JobPostingRepository jobPostingRepository;

//	saving job post data
	public JobPosting saveJobPosting(JobPosting jobPosting) {
		return jobPostingRepository.save(jobPosting);
	}

	public JobPosting saveJob(JobPosting jobPosting) {
		// Implement the logic to save the job posting
		return jobPostingRepository.save(jobPosting);
	}

//	showing job post on UI
	public List<JobPosting> getAllJobPostings() {
		return jobPostingRepository.findAll();
	}

	public JobPosting getJobPostingById(Long jobId) {
		return jobPostingRepository.findById(jobId).orElse(null);
	}

	// Updated method to accept Pageable

	public JobPostingService(JobPostingRepository jobPostingRepository) {
		this.jobPostingRepository = jobPostingRepository;
	}

	public Page<JobPosting> getAllJobPostings(Pageable pageable) {
		return jobPostingRepository.findAll(pageable);
	}

//	view jobs to company
	public List<JobPosting> getJobsByUser(Long userId) {
		return jobPostingRepository.findByUserId(userId);
	}

//	CRUD of jobs
	// Service method to get a job by ID
	public JobPosting getJobById(Long id) {
		return jobPostingRepository.findById(id).orElse(null);
	}

	// Service method to update a job
	public void updateJob(Long id, JobPosting updatedJob) {
		JobPosting existingJob = jobPostingRepository.findById(id).orElse(null);
		if (existingJob != null) {
			// Update job details
			existingJob.setProfile(updatedJob.getProfile());
			existingJob.setLocation(updatedJob.getLocation());
			existingJob.setWorkMode(updatedJob.getWorkMode());
			existingJob.setJobType(updatedJob.getJobType());
			existingJob.setExperience(updatedJob.getExperience());
			existingJob.setCtc(updatedJob.getCtc());

			// Save the updated job
			jobPostingRepository.save(existingJob);
		}
	}

	// Service method to delete a job by ID
	public void deleteJob(Long id) {
		jobPostingRepository.deleteById(id);
	}

}
