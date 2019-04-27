package ru.job4j.fraction;


import java.util.Comparator;
import java.util.Objects;

/**
 * Класс содержит данные о студенте.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 26.04.2019г.
 */
public class Student implements Comparable<Student> {

    /**
     * ФИО студента/
     */
    private String name;

    /**
     * Бал аттестата.
     */
    private int score;

    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }


    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", score=" + score + '}';
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.getScore(), this.score);
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
        return score == student.score
                && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}