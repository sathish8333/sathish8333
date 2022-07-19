package com.sr.registerstudent.service;

import com.sr.registerstudent.entity.Student;
import com.sr.registerstudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

public class StudentServiceImpl implements StudentService{

    @Autowired
    ValidationService validationService;

    @Autowired
    public StudentRepository studentRepository;

    String rollNumberPrefix ="11Ak1";
    Integer studentSerialNumber = 0 ;
    String studentRollNumber ="";

    @Override
    public Student getStudent(String rollnumber) {
        return studentRepository.findStudentByRollNumber(rollnumber);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public String processStudents(Student student) {
        Set<ConstraintViolation<Student>> errorsList = validationService.validateStudent(student);
        if (!errorsList.isEmpty()) {
            throw new ConstraintViolationException(errorsList);
        }
        getNewRollNumber(student.getStudentDepartment());//UUID.randomUUID().toString();
        student.setStudentSerialNumber(studentSerialNumber);
        student.setStudentRollNumber(studentRollNumber);
        saveStudent(student);
        return studentRollNumber;
    }

    @Override
    public void getNewRollNumber(String department) {
        generateRollNumber(department);
    }

    public void generateRollNumber(String department) {
        String serialNo  = studentRepository.getNewSerialNumber(department);
        if (serialNo==null){
            studentSerialNumber = 1;
        }else{
            studentSerialNumber = Integer.parseInt(serialNo)+1;
        }
        studentRollNumber = rollNumberPrefix+department.toUpperCase()+studentSerialNumber;
    }

}
