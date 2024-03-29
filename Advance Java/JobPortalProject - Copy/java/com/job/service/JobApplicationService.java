package com.job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.entity.JobApplications;
import com.job.entity.JobPosting;
import com.job.repository.JobApplicationRepository;

@Service
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationsRepository;

    @Autowired
    public JobApplicationService(JobApplicationRepository jobApplicationsRepository) {
        this.jobApplicationsRepository = jobApplicationsRepository;
    }

    public List<JobApplications> getApplicationsByJobPosting(JobPosting jobPosting) {
        return jobApplicationsRepository.findByJobPostingId(jobPosting.getId());
    }
    
    // Define method to update status to accepted
    public void updateStatusToAccepted(Long userId) {
        // Logic to update status to accepted
        // Assuming you have a method in your repository to update the status
        // jobApplicationsRepository.updateStatusToAccepted(userId);
    }
}
