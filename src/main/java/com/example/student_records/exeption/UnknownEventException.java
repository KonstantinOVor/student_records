package com.example.student_records.exeption;

public class UnknownEventException  extends RuntimeException {
    public UnknownEventException(String message) {
        super(message);
    }
}
