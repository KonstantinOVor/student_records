package com.example.student_records.events;


import com.example.student_records.repository.StudentRepository;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ApplicationStartedEvent extends ApplicationEvent {
    private final StudentRepository studentRepository;
    private boolean createStudentsOnStartup;
    public ApplicationStartedEvent(Object source, StudentRepository studentRepository) {
        super(source);
        this.studentRepository = studentRepository;
    }
}
