package com.sr.registerstudent.validator;

import com.sr.registerstudent.constants.StudentsConstants;
import com.sr.registerstudent.entity.Student;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class entityValidatorImpl implements ConstraintValidator<entityValidator, Student> {
    public List<String> errors = new ArrayList<>();
    public Boolean isValid = true;
    @Override
    public void initialize(entityValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Student student, ConstraintValidatorContext context) {
        this.verifyStudent(student);
        this.verifyDepartment(student);

        if (!errors.isEmpty()) {
            isValid= false;
            this.constructVoilations(context);
        }
        return isValid;
    }

    private void verifyStudent(Student student){
        if (student.getStudentName().isEmpty())
            errors.add(StudentsConstants.STUDENT_ERROR_01);
    }

    private void verifyDepartment(Student student){
        if (student.getStudentDepartment().isEmpty() || !Arrays.asList(StudentsConstants.VALID_DEPARTS).contains(student.getStudentDepartment()))
            errors.add(StudentsConstants.DEPARTMENT_ERROR);
    }

    private void constructVoilations(ConstraintValidatorContext context){
        context.disableDefaultConstraintViolation();
        errors.forEach(error -> context.buildConstraintViolationWithTemplate(error).addConstraintViolation());
    }
}
