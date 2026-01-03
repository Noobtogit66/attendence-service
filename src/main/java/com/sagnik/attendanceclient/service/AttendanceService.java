package com.sagnik.attendanceclient.service;

import com.sagnik.attendanceclient.exception.AttendenceNotFound;
import com.sagnik.attendanceclient.model.ApprovalStatus;
import com.sagnik.attendanceclient.model.Attendance;
import com.sagnik.attendanceclient.repository.AttendenceRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sagnik.attendanceclient.model.ApprovalStatus.APPROVED;
import static com.sagnik.attendanceclient.model.ApprovalStatus.PENDING;

@Service
public class AttendanceService {
    @Autowired
    private AttendenceRepository repository;
    public Attendance addAttendance(Attendance attendance)
    {
        return repository.save(attendance);
    }
    public Attendance getAttendance(String userId, String officeId) {
        long currentTime = Instant.now().toEpochMilli();
        long todayEpoch = LocalDate.now().toEpochDay();

        // Check for existing record
        Optional<Attendance> value = repository.findByUserIdAndDateEpoch(userId, todayEpoch);

        if (value.isEmpty()) {
            // Create NEW record if none exists
            Attendance newRecord = new Attendance();
            newRecord.setUserId(userId);
            newRecord.setOfficeId(officeId);
            newRecord.setHours(0);
            newRecord.setApprovalStatus(APPROVED);
            newRecord.setDateEpoch(todayEpoch);
            newRecord.setFirstEntry(currentTime);

            // Ensure the list is initialized (if not done in Entity)
            if (newRecord.getInOutHours() == null) {
                newRecord.setInOutHours(new ArrayList<>());
            }
            newRecord.getInOutHours().add(currentTime);

            // Save and return the new record
            return repository.save(newRecord);
        } else {
            // Update EXISTING record
            Attendance existing = value.get();

            // Safety check for null list
            if (existing.getInOutHours() == null) {
                existing.setInOutHours(new ArrayList<>());
            }

            existing.getInOutHours().add(currentTime);
            existing.setLastEntry(currentTime); // Update the last seen time

            // Save and return the updated record
            return repository.save(existing);
        }
    }

    public List<Attendance> getAttendenceList(String userId)
    {
        return repository.findAllByUserId(userId);
    }
    public void deleteAttendence(String Id)
    {

    }

    public @Nullable ApprovalStatus getApproval(String userId) {
        long todayEpoch = LocalDate.now().toEpochDay();
        Optional<Attendance> value = repository.findByUserIdAndDateEpoch(userId, todayEpoch);

        if (value.isEmpty()) {
            throw new AttendenceNotFound("Attendence not Found");
        }
        else{
          return value.get().getApprovalStatus();
            }
    }
    @Transactional
    public @Nullable ApprovalStatus setApproval(String userId, ApprovalStatus status) {
        long todayEpoch = LocalDate.now().toEpochDay();
        Optional<Attendance> value = repository.findByUserIdAndDateEpoch(userId, todayEpoch);

        if (value.isEmpty()) {
            throw new AttendenceNotFound("Attendence not Found");
        }
        else{
            Attendance existing=value.get();
            existing.setApprovalStatus(status);
            return repository.save(existing).getApprovalStatus();
        }
    }

    public @Nullable Attendance getManualAttendance(String userId, String officeId) {
        long currentTime = Instant.now().toEpochMilli();
        long todayEpoch = LocalDate.now().toEpochDay();

        // Check for existing record
        Optional<Attendance> value = repository.findByUserIdAndDateEpoch(userId, todayEpoch);

        if (value.isEmpty()) {
            // Create NEW record if none exists
            Attendance newRecord = new Attendance();
            newRecord.setUserId(userId);
            newRecord.setOfficeId(officeId);
            newRecord.setHours(0);
            newRecord.setApprovalStatus(PENDING);
            newRecord.setDateEpoch(todayEpoch);
            newRecord.setManualInEpoch(currentTime);

            // Ensure the list is initialized (if not done in Entity)
            if (newRecord.getInOutHours() == null) {
                newRecord.setInOutHours(new ArrayList<>());
            }
            newRecord.getInOutHours().add(currentTime);

            // Save and return the new record
            return repository.save(newRecord);
        } else {
            //  Update EXISTING record
            Attendance existing = value.get();

            // Safety check for null list
            if (existing.getInOutHours() == null) {
                existing.setInOutHours(new ArrayList<>());
            }

            existing.getInOutHours().add(currentTime);
            existing.setManualOutEpoch(currentTime); // Update the last seen time

            // Save and return the updated record
            return repository.save(existing);
        }
    }
}
