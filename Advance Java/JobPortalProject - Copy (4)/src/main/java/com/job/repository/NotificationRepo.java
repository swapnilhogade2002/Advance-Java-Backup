package com.job.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.job.entity.JobPosting;
import com.job.entity.Notification;
import com.job.entity.User;

public interface NotificationRepo extends JpaRepository<Notification, Long> {
	List<Notification> findByRecipientAndStatus(User recipient, boolean status);

	Notification findByRecipientAndMessage(User recipient, String message);

	boolean existsByRecipientIdAndMessage(Long userId, String string);

	boolean existsByRecipientAndMessage(User recipient, String message);

	boolean existsByRecipientAndCompanyAndMessage(User recipient, User company, String message);

	List<Notification> findByRecipient(User recipient);

	boolean existsByRecipientAndJobPostingAndMessage(User recipient, JobPosting jobPosting, String message);

	List<Notification> findByRecipientId(Long recipientId);

//    notification status 
		Page<Notification> findByCompanyId(Long companyId, Pageable pageable);
//    List<Notification> findByCompanyId(Long companyId);

}
