package com.example.student_records.service;

import com.example.student_records.events.ApplicationStartedEvent;
import com.example.student_records.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationLaunch {
    private final ApplicationEventPublisher eventPublisher;
    private final StudentRepository studentRepository;
    @Value("${app.create.enabled}")
    private boolean createStudentsOnStartup;

    public void launch() {
        if (createStudentsOnStartup) {
            eventPublisher.publishEvent(new ApplicationStartedEvent(this, studentRepository));
        }
    }
}
