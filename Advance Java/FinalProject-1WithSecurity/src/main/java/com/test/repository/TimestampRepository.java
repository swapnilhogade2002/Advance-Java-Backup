package com.test.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.entity.TimestampEntity;

public interface TimestampRepository extends JpaRepository<TimestampEntity, Long> {
	TimestampEntity findByUserIdAndPunchOutTimeIsNull(String userId);

	boolean existsByUserIdAndPunchInTimeGreaterThanEqual(String userId, LocalDateTime time);

	TimestampEntity findTopByUserIdAndPunchInTimeGreaterThanEqualOrderByPunchInTimeDesc(String userId,
			LocalDateTime time);

	@Query("SELECT COALESCE(SUM(t.punchOutTime - t.punchInTime), 0) FROM TimestampEntity t WHERE t.id = :id")
	long calculateTotalWorkSeconds(@Param("id") Long id);

	@Modifying
	@Query("INSERT INTO EmployeeAttendance (employeeId, date, totalWorkHours) "
			+ "SELECT t.userId, CURRENT_DATE, COALESCE(SUM(t.punchOutTime - t.punchInTime), 0) "
			+ "FROM TimestampEntity t WHERE t.id = :id GROUP BY t.userId")
	void storeDateWiseData(@Param("id") Long id);

}
