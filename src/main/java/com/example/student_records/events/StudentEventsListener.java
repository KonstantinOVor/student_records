package com.example.student_records.events;

import com.example.student_records.entity.Student;
import com.example.student_records.exeption.UnknownEventException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StudentEventsListener {

    @EventListener(StudentAddedEvent.class)
    public void onTheAddEvent(StudentAddedEvent event) {
        if (event.getStudent() instanceof Student) {
            Student student = event.getStudent();
            System.out.println("Добавлен студент: " + student.toString());
        } else {
            throw new UnknownEventException("Неизвестное событие");
        }
    }
    @EventListener(StudentDeletedEvent.class)
    public void handleStudentDeletion(StudentDeletedEvent event) {
        if (event.getStudent() instanceof Student) {
            Student student = event.getStudent();
            System.out.println("Удален студент c id = " + student.getId());
        }  else {
            throw new UnknownEventException("Неизвестное событие");
        }
    }
}
