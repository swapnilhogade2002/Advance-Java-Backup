package com.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.entity.Notification;
import com.job.entity.User;
import com.job.repository.NotificationRepo;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepo notificationRepository;

    public void sendNotification(User recipient, String message) {
        Notification notification = new Notification();
        notification.setRecipient(recipient);
        notification.setMessage(message);
        notification.setStatus(false); // Unread initially
        notificationRepository.save(notification);
    }
}