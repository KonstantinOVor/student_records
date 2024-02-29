package com.example.student_records.config;

import com.example.student_records.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
@ConditionalOnProperty(name = "app.create.enabled")
public class StudentInitializerConfig {
    private final StudentRepository studentRepository;

    @PostConstruct
    public void init() {
        studentRepository.addStudent("Иванов", "Иван", 20);
        studentRepository.addStudent("Петров", "Петр", 21);
        studentRepository.addStudent("Сидоров", "Сидор", 22);
        studentRepository.addStudent("Васильев", "Василий", 23);
        studentRepository.addStudent("Антонов", "Антон", 24);
    }
}

