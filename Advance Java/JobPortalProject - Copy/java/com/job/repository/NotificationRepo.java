package com.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.entity.Notification;
import com.job.entity.User;

public interface NotificationRepo extends JpaRepository<Notification, Long> {
	List<Notification> findByRecipientAndStatus(User recipient, boolean status);

	boolean existsByRecipientIdAndMessage(Long userId, String string);

}
