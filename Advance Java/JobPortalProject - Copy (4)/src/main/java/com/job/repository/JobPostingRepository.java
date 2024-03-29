package com.job.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.job.entity.JobPosting;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {

	Page<JobPosting> findByUserId(Long userId, Pageable pageable);

	List<JobPosting> findByUserId(Long userId);

//	
	Page<JobPosting> findAll(Pageable pageable);

	List<JobPosting> findByJobCategory(String category);

//	Each category count
	@Query("SELECT COUNT(jp) FROM JobPosting jp WHERE jp.jobCategory = 'Marketing'")
	Long countByJobCategoryMarketing();

	@Query("SELECT COUNT(jp) FROM JobPosting jp WHERE jp.jobCategory = 'Customer Service'")
	Long countByJobCategoryCustomeService();

	@Query("SELECT COUNT(jp) FROM JobPosting jp WHERE jp.jobCategory = 'Human Resource'")
	Long countByJobCategoryHumanResource();

	@Query("SELECT COUNT(jp) FROM JobPosting jp WHERE jp.jobCategory = 'Project Management'")
	Long countByJobCategoryProjectManagement();

	@Query("SELECT COUNT(jp) FROM JobPosting jp WHERE jp.jobCategory = 'Business Development'")
	Long countByJobCategoryBussinessDevelopment();

	@Query("SELECT COUNT(jp) FROM JobPosting jp WHERE jp.jobCategory = 'Sales and Communication'")
	Long countByJobCategorySalesAndCommunication();

	@Query("SELECT COUNT(jp) FROM JobPosting jp WHERE jp.jobCategory = 'Teaching and Education'")
	Long countByJobCategoryTeachingAndEducation();

	@Query("SELECT COUNT(jp) FROM JobPosting jp WHERE jp.jobCategory = 'Design and Creative'")
	Long countByJobCategoryDesignAndCreative();

}
