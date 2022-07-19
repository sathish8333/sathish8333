package com.sr.registerstudent.service;

import com.sr.registerstudent.entity.Student;
import org.springframework.context.annotation.Bean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Set;

public class ValidationService {

    public Set<ConstraintViolation<Student>> validateStudent(Student student){
       return Validation.buildDefaultValidatorFactory().getValidator().validate(student);
    }
}
