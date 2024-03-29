package com.job.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.entity.JobApplications;
import com.job.entity.JobPosting;
import com.job.repository.JobApplicationRepository;

@Service
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationsRepository;
    
    @Autowired
    private JobApplicationRepository jobApplicationRepository;

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
    
 // Method to delete job application
    public void updateJobApplicationStatus(Long jobId, boolean status) {
        // Fetch the job application from the database using jobId
        Optional<JobApplications> optionalJobApplication = jobApplicationRepository.findById(jobId);
        
        // If the job application exists, update its status and save it back to the database
        optionalJobApplication.ifPresent(jobApplications -> {
            jobApplications.setAccepted(status);
            jobApplicationRepository.save(jobApplications);
        });
    }
    
    


}
