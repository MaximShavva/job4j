package ru.job4j.fraction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс содержит метод levelOf для выборки студентов по баллам,
 * с отсеиванием отчисленных студентов.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 26.04.2019г.
 */
public class School {

    /**
     * Порядок действий:
     * - Отсортировать список.
     * - Используя метод flatMap убрать null
     * - Используя метод takeWhile получить нужный поток.
     * - Сохранить поток в List.
     *
     * @param students Список всех студентов.
     * @param bound    граница зачисления в список.
     * @return зачисленные студенты.
     */
    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .sorted((o1, o2) -> {
                    if (o1 == null) {
                        return o2 == null ? 0 : -1;
                    }
                    return o2 == null ? 1 : o1.compareTo(o2);
                })
                .flatMap(Stream::ofNullable)
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());
    }
}