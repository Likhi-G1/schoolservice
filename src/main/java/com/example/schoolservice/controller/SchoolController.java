package com.example.schoolservice.controller;

import com.example.schoolservice.entity.SchoolExcursion;
import com.example.schoolservice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/register")
    public String registerStudent(@RequestBody SchoolExcursion student) {
        return schoolService.registerStudent(student);
    }

    @GetMapping("/registrations")
    public List<SchoolExcursion> getAllRegistrations() {
        return schoolService.getAllRegistrations();
    }
}
