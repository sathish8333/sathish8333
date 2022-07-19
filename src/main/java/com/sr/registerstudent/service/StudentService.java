package com.sr.registerstudent.service;

import com.sr.registerstudent.entity.Student;

import java.util.List;

public interface StudentService {
    Student getStudent(String rollnumber);
    void saveStudent(Student student);
    List<Student> getAllStudents();

    String processStudents(Student student);

    void getNewRollNumber(String department);
}
