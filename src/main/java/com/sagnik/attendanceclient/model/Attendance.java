package com.sagnik.attendanceclient.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String userId;

    private long dateEpoch;
    private long firstEntry;
    private long lastEntry;

    private String officeId;
    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;

//    [9,10,12,2,4,7]
    @ElementCollection
    private List<Long> inOutHours=new ArrayList<>();

    private int hours;
    private long manualInEpoch;
    private long manualOutEpoch;



}
