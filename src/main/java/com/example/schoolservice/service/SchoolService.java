package com.example.schoolservice.service;

import com.example.schoolservice.entity.SchoolExcursion;

import java.util.List;

public interface SchoolService {
//    String registerStudent(SchoolExcursion student);
    List<SchoolExcursion> getAllRegistrations();
}
