package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.entity.JobApplications;
import com.job.entity.JobPosting;
import com.job.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface JobApplicationRepository extends JpaRepository<JobApplications, Long> {

	boolean existsByUserAndJobPosting(User currentUser, JobPosting jobPosting);

	List<JobApplications> findByJobPosting(JobPosting jobPosting);

	List<JobApplications> findByJobPostingId(Long jobPostingId);

	Optional<JobApplications> findById(Long id);

	List<JobApplications> findByUserId(Long userId);

}
