package com.sagnik.attendanceclient.controller;


import com.sagnik.attendanceclient.model.Attendence;
import com.sagnik.attendanceclient.service.AttendenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendence")
public class AttendenceController {
@Autowired
private AttendenceService service;
@GetMapping("/getAttendence/{userId}")
    public ResponseEntity<Attendence> getAttendence(@PathVariable String userId)
{
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getAttendence(userId));
}
//    Manual Attendence Entry



//    Attendence Approval


//    Get Attendence by employee id


//    Get Attendence by Office


//    Get All Attendence Record



}
