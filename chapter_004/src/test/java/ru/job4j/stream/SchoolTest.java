package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования School.collect().
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 24.04.2019г.
 */
public class SchoolTest {

    /**
     * Список студентов будем использовать в методах по тестированию
     * School.collect().
     */
    private static final List<Student> students = List.of(
            new Student("Arkadij", 98),
            new Student("Phedor", 63),
            new Student("Michail", 77),
            new Student("Eugen", 45),
            new Student("Daniel", 46)
    );

    /**
     * Тест выбора студентов с баллами от 0 до 50
     */
    @Test
    public void when0To50ThenGroupC() {
        School school = new School();
        List<Student> low = school.collect(students,
                student -> student.getScore() >= 0 && student.getScore() < 51);
        assertThat(low.toString(), is(List.of(new Student("Eugen", 45),
                new Student("Daniel", 46)).toString()));
    }

    /**
     * Тест выбора студентов с баллами от 51 до 70
     */
    @Test
    public void when51To70ThenGroupB() {
        School school = new School();
        List<Student> low = school.collect(students,
                student -> student.getScore() > 50 && student.getScore() < 71);
        assertThat(low.toString(),
                is(List.of(new Student("Phedor", 63)).toString()));
    }

    /**
     * Тест выбора студентов с баллами от 71 до 100
     */
    @Test
    public void when71To100ThenGroupA() {
        School school = new School();
        List<Student> low = school.collect(students,
                student -> student.getScore() > 70 && student.getScore() <= 100);
        assertThat(low.toString(), is(List.of(new Student("Arkadij", 98),
                new Student("Michail", 77)).toString()));
    }
}