package com.sagnik.attendanceclient.repository;

import com.sagnik.attendanceclient.model.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendenceRepository extends JpaRepository<Attendence, String> {
}
