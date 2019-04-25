package ru.job4j.map;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Класс для тестирования School.convert().
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 25.04.2019г.
 */
public class SchoolTest {

    /**
     * Список студентов будем использовать в методе whenListThenMap.
     */
    private static final List<Student> STUDENTS = List.of(
            new Student("Arkadij", 98),
            new Student("Phedor", 63),
            new Student("Michail", 77),
            new Student("Eugen", 45),
            new Student("Eugen", 46)
    );

    /**
     * Тест метода convert.
     */
    @Test
    public void whenListThenMap() {
        School school = new School();
        Map<String, Student> students = school.convert(STUDENTS);
        assertThat(students.keySet(), is(Set.of("Arkadij", "Phedor", "Michail", "Eugen")));
        assertTrue(students.values().containsAll(STUDENTS));
    }
}