package com.sagnik.attendanceclient.repository;

import com.sagnik.attendanceclient.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AttendenceRepository extends JpaRepository<Attendance, String> {

    List<Attendance> findAllByUserId(String userId);
    Optional<Attendance> findByUserIdAndDateEpoch(String userId, long todayEpoch);
}
