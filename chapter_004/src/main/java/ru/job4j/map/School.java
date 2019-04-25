package ru.job4j.map;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс содержит метод convert() для выборки студентов по баллам.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 25.04.2019г.
 */
public class School {

    /**
     * @param students Список всех студентов.
     * @return Отображение списка в Map<String, Student>.
     */
    Map<String, Student> convert(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(Collectors.toMap(Student::getName, student -> student));
    }
}