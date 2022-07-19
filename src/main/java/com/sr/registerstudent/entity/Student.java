package com.sr.registerstudent.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sr.registerstudent.validator.entityValidator;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@entityValidator
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int sequenceId;
    String studentName;
    String studentRollNumber;
    Integer studentSerialNumber;
    String studentDepartment;
    String mobile;
}
