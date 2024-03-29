package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}