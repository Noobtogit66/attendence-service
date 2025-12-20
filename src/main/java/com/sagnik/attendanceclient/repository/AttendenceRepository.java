package com.sagnik.attendanceclient.repository;

import com.sagnik.attendanceclient.model.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AttendenceRepository extends JpaRepository<Attendence, String> {
    Optional<Attendence> findByIdAndEpochTime(String userId, long dateEpoch);
    List<Attendence> findAllByUserId(String userId);
}
