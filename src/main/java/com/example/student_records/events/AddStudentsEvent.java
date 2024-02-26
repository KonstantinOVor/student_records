package com.example.student_records.events;

import com.example.student_records.repository.StudentRepository;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
@Getter
public class AddStudentsEvent extends ApplicationEvent {

    private final StudentRepository studentRepository;
    public AddStudentsEvent(Object source, StudentRepository studentRepository) {
        super(source);
        this.studentRepository = studentRepository;
    }
}
