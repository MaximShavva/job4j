package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Класс содержит метод collect() для выборки студентов по баллам.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 24.04.2019г.
 */
public class School {

    /**
     * @param students Список всех студентов.
     * @param predict Реализация интерфейса Predicate с нужным нам условием выборки.
     * @return Студенты, проходящие по баллам.
     */
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }
}