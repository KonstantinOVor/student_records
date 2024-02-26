package com.example.student_records.events;

import com.example.student_records.entity.Student;
import com.example.student_records.exeption.UnknownEventException;
import com.example.student_records.messages.ProgramMessages;
import com.example.student_records.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class StudentEventsListener {

    @EventListener(AddStudentsEvent.class)
    public void onApplicationEvent(AddStudentsEvent event) {
        StudentRepository studentRepository = event.getStudentRepository();
        addInitialStudents(studentRepository);
    }

    private void addInitialStudents(StudentRepository studentRepository) {
        studentRepository.addStudent("Иванов", "Иван", 20);
        studentRepository.addStudent("Петров", "Петр", 21);
        studentRepository.addStudent("Сидоров", "Сидор", 22);
        studentRepository.addStudent("Васильев", "Василий", 23);
        studentRepository.addStudent("Антонов", "Антон", 24);
    }

    @EventListener(StudentAddedEvent.class)
    public void onTheAddEvent(StudentAddedEvent event) {
        if (event.getStudent() instanceof Student) {
            Student student = event.getStudent();
            System.out.println(ProgramMessages.ADD_STUDENT.getDescription()
                    + student.toString());
        } else {
            throw new UnknownEventException(ProgramMessages.UNKNOWN_EVENT.getDescription());
        }
    }
    @EventListener(StudentDeletedEvent.class)
    public void handleStudentDeletion(StudentDeletedEvent event) {
        if (event.getStudent() instanceof Student) {
            Student student = event.getStudent();
            System.out.println(ProgramMessages.DELETE_STUDENT.getDescription()
                    + student.getId());
        }  else {
            throw new UnknownEventException(ProgramMessages.UNKNOWN_EVENT.getDescription());
        }
    }

}
