package com.example.schoolservice.controller;

import com.example.schoolservice.entity.SchoolExcursion;
import com.example.schoolservice.entity.Student;
import com.example.schoolservice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findHealthStudentStatus")
    public String getHealthStatusFromStudentService() {
        String studentServiceUrl = "http://localhost:8081/api/student/healthStatus";
        return restTemplate.getForObject(studentServiceUrl, String.class);
    }

    @PostMapping("/registerStudent")
    public ResponseEntity<?> registerStudent(@RequestBody Student student) {
        // Assuming StudentService is running on http://localhost:8082
        String studentServiceUrl2 = "http://localhost:8081/api/student/add";

        // Make the HTTP POST call to StudentService
        ResponseEntity<?> response = restTemplate.postForEntity(studentServiceUrl2, student, Object.class);

        // Return the response received from StudentService
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @PostMapping("/register")
    public String registerStudent(@RequestBody SchoolExcursion student) {
        return schoolService.registerStudent(student);
    }

    @GetMapping("/registrations")
    public List<SchoolExcursion> getAllRegistrations() {
        return schoolService.getAllRegistrations();
    }
}
