package com.example.student_records.messages;

public enum ProgramMessages {
    LIST_IS_EMPTY ("Список пуст"),
    ADD_STUDENT ("Добавлен студент: "),
    DELETE_STUDENT ("Удален студент c id = "),
    UNKNOWN_EVENT ("Неизвестное событие"),
    CLEAR_ALL_STUDENTS ("Список студентов очищен"),
    STUDENT_NOT_FOUND ("Студент с таким id не найден");
    private final String description;

    ProgramMessages(String description) {

        this.description = description;
    }
    public String getDescription() {

        return description;
    }

}
