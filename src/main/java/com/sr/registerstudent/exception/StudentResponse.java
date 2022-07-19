package com.sr.registerstudent.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

import java.util.List;

@JsonSerialize
@Getter
public class StudentResponse {
    private List<String> studentRollNumbers;

    public StudentResponse(List<String> messages) {
        this.studentRollNumbers = messages;
    }
}
