package com.example.student_records.repository.impl;

import com.example.student_records.entity.Student;
import com.example.student_records.events.StudentAddedEvent;
import com.example.student_records.events.StudentDeletedEvent;
import com.example.student_records.exeption.StudentNotFoundException;
import com.example.student_records.messages.ProgramMessages;
import com.example.student_records.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.*;

@Slf4j
@ShellComponent
@RequiredArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {
   protected List<Student> studentList = new ArrayList<>();
   private final ApplicationEventPublisher eventPublisher;

    @ShellMethod(key = "add", value = "Add new student")
    @Override
    public void addStudent(String lastName, String firstName, int age) {
        Student student = Student.builder()
                .id(generateId())
                .lastName(lastName)
                .firstName(firstName)
                .age(age)
                .build();
        studentList.add(student);
        eventPublisher.publishEvent(new StudentAddedEvent(this, student));
    }

    @ShellMethod(key = "del", value = "Delete student by id")
    @Override
    public void deleteStudent(Long id) {
        Student studentToRemove = null;
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            studentList.remove(studentToRemove);
            eventPublisher.publishEvent(new StudentDeletedEvent(this, studentToRemove));
        } else {
            throw new StudentNotFoundException(ProgramMessages.STUDENT_NOT_FOUND.getDescription());
        }
    }

    @ShellMethod(key = "show", value = "Show all students")
    @Override
    public void getAllStudents() {
        if (!studentList.isEmpty()) {
            for (Student student : studentList) {
                System.out.println(student.toString());
            }
        } else {
            throw new StudentNotFoundException(ProgramMessages.LIST_IS_EMPTY.getDescription());
        }
    }

    @ShellMethod(key = "cl", value = "Clear all students")
    @Override
    public void clearAllStudents() {
        if (!studentList.isEmpty()) {
            studentList.clear();
            System.out.println(ProgramMessages.CLEAR_ALL_STUDENTS.getDescription());
        } else {
            throw new StudentNotFoundException(ProgramMessages.LIST_IS_EMPTY.getDescription());
        }
    }
    private Long generateId() {
        return studentList.size() + 1L;
    }
}
