package com.sr.registerstudent.controller;

import com.sr.registerstudent.config.MyConfiguration;
import com.sr.registerstudent.entity.Student;
import com.sr.registerstudent.exception.StudentResponse;
import com.sr.registerstudent.service.StudentService;
import com.sr.registerstudent.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
public class StudentRegisterController {

    @Autowired
    @Qualifier("validation")
    private ValidationService validationService;

    @Autowired
    private StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(StudentRegisterController.class);

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<StudentResponse> registerStudent(@RequestBody Student student) {
        logger.info("request body is "+student);
        String rollNumber = studentService.processStudents(student);
        List<String> rollNumbers = new ArrayList<>();
        rollNumbers.add(rollNumber);
        StudentResponse response = new StudentResponse(rollNumbers);
        return new ResponseEntity<StudentResponse>(response, HttpStatus.CREATED);
    }

    @PostMapping("/registerStudents")
    @ResponseBody
    public ResponseEntity<StudentResponse> registerMultipleStudent(@RequestBody List<Student> students) {
        List<String> rollNumbers = new ArrayList<>();
        students.forEach(student -> {
            rollNumbers.add(studentService.processStudents(student));
        });
        StudentResponse response = new StudentResponse(rollNumbers);
        return new ResponseEntity<StudentResponse>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getStudent/{rollnumber}")
    public Student getStudent(@PathVariable String rollnumber) {
        return studentService.getStudent(rollnumber);
    }

    @GetMapping("/loadAllStudents")
    public String getStudent() {
        for (Student student : MyConfiguration.users) {
            studentService.processStudents(student);
        }
        String str = "lodded data successfully";
        return str;
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
