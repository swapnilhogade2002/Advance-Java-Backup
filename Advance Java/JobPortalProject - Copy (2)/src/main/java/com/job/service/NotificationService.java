package com.job.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.entity.JobApplications;
import com.job.entity.JobPosting;
import com.job.entity.Notification;
import com.job.entity.User;
import com.job.repository.JobApplicationRepository;
import com.job.repository.NotificationRepo;

@Service
public class NotificationService {
	@Autowired
	private NotificationRepo notificationRepository;

	@Autowired
	private JobApplicationRepository jobApplicationRepository;

//	public void sendNotification(User recipient, String message) {
//		Notification notification = new Notification();
//		notification.setRecipient(recipient);
//		notification.setMessage(message);
//		notification.setStatus(false); // Unread initially
//		notificationRepository.save(notification);
//	}

	public void sendNotification(User recipient, JobPosting jobPosting, String message) {
		Notification notification = new Notification();
		notification.setRecipient(recipient);
		notification.setMessage(message);
		notification.setStatus(false); // Unread initially
		notification.setJobPosting(jobPosting); // Set the jobPosting property
		notificationRepository.save(notification);
	}

	public List<Notification> findByRecipient(User recipient) {
		return notificationRepository.findByRecipient(recipient);
	}

	public List<Notification> getAllJobNotification() {
		return notificationRepository.findAll();
	}

	public List<Notification> getAllJobNotificationForUser(Long userId) {
		// Implement the logic to retrieve notifications for the given user ID
		return notificationRepository.findByRecipientId(userId);
	}
//	
	public List<Notification> getAllJobNotificationForCompany(Long userId) {
	    return notificationRepository.findByCompanyId(userId);
	}


//	 job status from notification entity for company
	 // job status from notification entity for company
//    public List<Notification> getAllJobNotificationForCompany(Long companyId) {
//        // Implement the logic to retrieve notifications for the given company ID
//        return notificationRepository.findByRecipientId(companyId);
//    }

//   status updating 
	public void updateAcceptedStatus(Long jobId, boolean accepted) {
		Optional<JobApplications> optionalJobApplication = jobApplicationRepository.findById(jobId);
		if (optionalJobApplication.isPresent()) {
			JobApplications jobApplication = optionalJobApplication.get();
			jobApplication.setAccepted(accepted);
			jobApplicationRepository.save(jobApplication);
		} else {
			// Handle the case where the job application with the given ID is not found
			throw new IllegalArgumentException("Job application with ID " + jobId + " not found");
		}
	}

}