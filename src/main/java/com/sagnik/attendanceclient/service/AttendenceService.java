package com.sagnik.attendanceclient.service;

import com.sagnik.attendanceclient.model.Attendence;
import com.sagnik.attendanceclient.repository.AttendenceRepository;
import com.thoughtworks.xstream.converters.time.LocalDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AttendenceService {
    @Autowired
    private AttendenceRepository repository;
    public Attendence addAttendence(Attendence attendence)
    {
        return repository.save(attendence);
    }
    public Attendence getAttendence(String userId)
    {

        return repository.findByIdAndEpochTime(userId,LocalDate.now().toEpochDay()).get();
    }

    public List<Attendence> getAttendenceList(String userId)
    {
        return repository.findAllByUserId(userId);
    }
    public void deleteAttendence(String Id)
    {

    }

}
