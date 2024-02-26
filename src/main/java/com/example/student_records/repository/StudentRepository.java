package com.example.student_records.repository;

import com.example.student_records.entity.Student;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

public interface StudentRepository {

    void addStudent(String lastName, String firstName, int age);
    void deleteStudent(Long id);
    void getAllStudents();
    void clearAllStudents();
}
