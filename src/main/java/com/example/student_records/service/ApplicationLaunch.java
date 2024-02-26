package com.example.student_records.service;

import com.example.student_records.events.AddStudentsEvent;
import com.example.student_records.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "app.create.enabled", havingValue = "true")
public class ApplicationLaunch implements CommandLineRunner {
    private final ApplicationEventPublisher eventPublisher;
    private final StudentRepository studentRepository;


    @Override
    public void run(String... args) throws Exception {
        eventPublisher.publishEvent(new AddStudentsEvent(this, studentRepository));
    }
}
