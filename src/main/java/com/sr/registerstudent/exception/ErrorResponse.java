package com.sr.registerstudent.exception;

import java.util.List;


public class ErrorResponse {
    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public ErrorResponse(List<String> errors) {
        this.errors = errors;
    }

    List<String> errors;
}
