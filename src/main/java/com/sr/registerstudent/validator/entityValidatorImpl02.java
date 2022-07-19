package com.sr.registerstudent.validator;

import com.sr.registerstudent.entity.Student;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class entityValidatorImpl02 implements ConstraintValidator<entityValidator, Student> {
    public List<String> errors = new ArrayList<>();
    public Boolean isValid = true;

    @Override
    public void initialize(entityValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Student student, ConstraintValidatorContext context) {
        this.verifyStudent(student, context);
        this.verifyDepartment(student, context);

        return isValid;
    }

    private void verifyStudent(Student student, ConstraintValidatorContext context) {
        if (student.getStudentName().isEmpty()) {
            isValid = false;
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("empty student name").addConstraintViolation();
        }
    }

    private void verifyDepartment(Student student, ConstraintValidatorContext context) {
        if (student.getStudentDepartment().isEmpty()) {
            isValid = false;
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("empty department name01").addConstraintViolation();
        }
    }

    private void constructVoilations(ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        errors.forEach(error -> context.buildConstraintViolationWithTemplate(error).addConstraintViolation());
    }
}
