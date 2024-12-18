package com.example.schoolservice.service.impl;

import com.example.schoolservice.entity.SchoolExcursion;
import com.example.schoolservice.repository.SchoolRepository;
import com.example.schoolservice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

//    @Override
//    public String registerStudent(SchoolExcursion student) {
//        // Fetch already registered students based on the student's standard
//        List<SchoolExcursion> registeredStudents = schoolRepository.findByStandard(student.getStandard());
//
//        // Check if the number of students is 25 or more
//        if (registeredStudents.size() >= 25) {
//            return "Minimum criteria is filled.";
//        }
//
//        // Save the student registration
//        schoolRepository.save(student);
//        return "Student registered successfully!";
//    }

    @Override
    public List<SchoolExcursion> getAllRegistrations() {
        return schoolRepository.findAll();
    }
}
