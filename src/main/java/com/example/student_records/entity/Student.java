package com.example.student_records.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@Builder
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    @Override
    public String toString() {
        return id + ". Имя = '" + firstName + '\'' +
                ", Фамилия = '" + lastName + '\'' +
                ", возраст = " + age;
    }
}
