package com.sr.registerstudent.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sr.registerstudent.entity.Student;
import com.sr.registerstudent.service.StudentService;
import com.sr.registerstudent.service.StudentServiceImpl;
import com.sr.registerstudent.service.ValidationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyConfiguration {
    public static List<Student> users = new ArrayList<>();

    @Bean({"validation"})
    public ValidationService getValidationService() {
        return new ValidationService();
    }

    @Bean
    @Primary
    public StudentService getStudentService() {
        return new StudentServiceImpl();
    }

    //@Bean
    CommandLineRunner runner(StudentService studentService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Student>> typeReference = new TypeReference<List<Student>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("classpath/resources/json/students.json");
            try {
                users = mapper.readValue(inputStream, typeReference);
                users.forEach(student -> {
                    studentService.saveStudent(student);
                });
                System.out.println("Users Saved!");
            } catch (IOException e) {
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }
}
