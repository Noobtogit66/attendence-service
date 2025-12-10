package com.sagnik.attendanceclient.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Attendence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String userId;

    private long dateEpoch;
    private long firstEntry;
    private long lastEntry;

    private String officeId;

    private ApprovalStatus approvalStatus;

//    [9,10,12,2,4,7]
    private List<Long> inOutHours;


    private long manualInEpoch;
    private long manualOutEpoch;



}
