package com.job.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.job.entity.JobPosting;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
	List<JobPosting> findByUserId(Long userId);

//	public Page<JobPosting> findJobByUser(@Param("userId") int userId, Pageable pageble)
//	
	 Page<JobPosting> findAll(Pageable pageable);
	
}
