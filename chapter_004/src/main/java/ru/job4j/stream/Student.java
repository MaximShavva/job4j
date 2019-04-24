package ru.job4j.stream;

/**
 * Класс содержит данные о студенте.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 24.04.2019г.
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

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}