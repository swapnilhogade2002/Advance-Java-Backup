package com.test.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.test.entity.TimestampEntity;
import com.test.repository.TimestampRepository;

import jakarta.transaction.Transactional;

@Service
public class TimestampService {

	private static final Duration TWENTY_FOUR_HOURS = Duration.ofHours(24);

	@Autowired
	private TimestampRepository timestampRepository;

	public void punchIn(String userId) {
		// Check if the user has punched in within the last 24 hours
		if (!hasUserPunchedInWithin24Hours(userId)) {
			TimestampEntity punchEntity = new TimestampEntity();
			punchEntity.setUserId(userId);
			punchEntity.setPunchInTime(LocalDateTime.now());
			timestampRepository.save(punchEntity);
		}
		// else: User has already punched in within the last 24 hours, do nothing
	}

	public void punchOut(String userId) {
		// Check if the user has punched in and hasn't punched out yet
		TimestampEntity punchEntity = timestampRepository.findByUserIdAndPunchOutTimeIsNull(userId);
		if (punchEntity != null) {
			punchEntity.setPunchOutTime(LocalDateTime.now());
			timestampRepository.save(punchEntity);
		}
		// else: User has already punched out or hasn't punched in, do nothing
	}

	private boolean hasUserPunchedInWithin24Hours(String userId) {
		LocalDateTime twentyFourHoursAgo = LocalDateTime.now().minus(TWENTY_FOUR_HOURS);
		return timestampRepository.existsByUserIdAndPunchInTimeGreaterThanEqual(userId, twentyFourHoursAgo);
	}

//	CRUD

	public TimestampEntity saveTimestamp(TimestampEntity timestampEntity) {
		return timestampRepository.save(timestampEntity);
	}

	public List<TimestampEntity> getAllTimestamps() {
		return timestampRepository.findAll();
	}

	public TimestampEntity getTimestampById(Long id) {
		return timestampRepository.findById(id).orElse(null);
	}

	public void deleteTimestamp(Long id) {
		timestampRepository.deleteById(id);
	}

	public Duration calculateDuration(Long id) {
		TimestampEntity timestampEntity = timestampRepository.findById(id).orElse(null);

		if (timestampEntity != null && timestampEntity.getPunchInTime() != null
				&& timestampEntity.getPunchOutTime() != null) {
			return Duration.between(timestampEntity.getPunchInTime(), timestampEntity.getPunchOutTime());
		}

		return Duration.ZERO;
	}

//	taking all data from timestamp
	public List<TimestampEntity> getAllData() {
		return timestampRepository.findAll();
	}

//	after clicking on approve data should be deleted and added into new database 
	@Transactional
	public void deleteTimestampTable(Long id) {
		// Implement logic to delete the timestamp data by id
		// Example: timestampRepository.deleteById(id);
	}

	@Transactional
	public void approveTimestamp(Long id) {
	    TimestampEntity timestampEntity = timestampRepository.findById(id).orElse(null);

	    if (timestampEntity != null) {
	        // Calculate total work seconds
	        long totalSeconds = timestampRepository.calculateTotalWorkSeconds(id);

	        // Store date-wise data in EmployeeAttendance table
	        timestampRepository.storeDateWiseData(id);

	        // Delete the timestamp data
	        timestampRepository.deleteById(id);
	    }
	}


}
