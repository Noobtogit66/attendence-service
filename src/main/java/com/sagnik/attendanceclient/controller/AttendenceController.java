package com.sagnik.attendanceclient.controller;


import com.sagnik.attendanceclient.model.ApprovalStatus;
import com.sagnik.attendanceclient.model.Attendance;
import com.sagnik.attendanceclient.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendence")
public class AttendenceController {
@Autowired
private AttendanceService service;
//CardSwipe Entry
@GetMapping("/getAttendance/{userId}/{officeId}")
    public ResponseEntity<Attendance> getAttendance(@PathVariable String userId,@PathVariable String officeId)
{
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getAttendance(userId,officeId));
}
//    Manual Attendance Entry
@GetMapping("/getManualAttendance/{userId}/{officeId}")
public ResponseEntity<Attendance> getManualAttendance(@PathVariable String userId,@PathVariable String officeId)
{
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getManualAttendance(userId,officeId));
}


//    Attendance Approval
    @GetMapping("/getApproval/{userId}")
    public ResponseEntity<ApprovalStatus> getApproval(@PathVariable String userId)
    {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getApproval(userId));
    }
    @GetMapping("/setApproval/{userId}/{status}")
    public ResponseEntity<ApprovalStatus> setApproval(@PathVariable String userId,@PathVariable  ApprovalStatus status)
    {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.setApproval(userId,status));
    }
//    Get Attendance by employee id










//    Get Attendance by Office


//    Get All Attendance Record



}
