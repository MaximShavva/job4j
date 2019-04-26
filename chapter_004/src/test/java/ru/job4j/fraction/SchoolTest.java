package ru.job4j.fraction;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования School.levelOf().
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 26.04.2019г.
 */
public class SchoolTest {

    /**
     * Тест выбора студентов с баллами от 50 до 100
     */
    @Test
    public void whenLargerThenList() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(null);
        students.add(new Student("S.M.V.", 69));
        students.add(new Student("A.I.I.", 98));
        students.add(null);
        students.add(new Student("K.M.A.", 48));
        List<Student> bounded = school.levelOf(students, 50);
        assertThat(bounded, is(List.of(
                new Student("A.I.I.", 98),
                new Student("S.M.V.", 69)
        )));
    }
}