package ru.job4j.map;

import java.util.Objects;

/**
 * Класс содержит данные о студенте.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 25.04.2019г.
 */
public class Student {

    /**
     * Имя студента.
     */
    private final String name;

    /**
     * Баллы студента.
     */
    private final int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", score=" + score + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}