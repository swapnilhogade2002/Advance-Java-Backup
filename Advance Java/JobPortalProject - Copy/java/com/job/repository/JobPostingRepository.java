package com.job.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.entity.JobPosting;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
	   List<JobPosting> findByUserId(Long userId);
}
