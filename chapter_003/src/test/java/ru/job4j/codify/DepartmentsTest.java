package ru.job4j.codify;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест методов работы со списком подразделений класса Departments.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 20.04.2019г.
 */
public class DepartmentsTest {
    /**
     * Тест, когда пропущена зпись подразделения отдельной строкой.
     */
    @Test
    public void whenMissed() {
        Departments deps = new Departments();
        List<String> input = List.of("k1/sk1", "k1/sk2");
        List<Departments.Org> expect = List.of(
                new Departments.Org(List.of("k1")),
                new Departments.Org(List.of("k1", "sk1")),
                new Departments.Org(List.of("k1", "sk2"))
        );
        List<Departments.Org> result = deps.convert(input);
        assertThat(result, is(expect));
    }

    /**
     * Тест сортировки подразделений в восходящем порядке.
     */
    @Test
    public void whenAsc() {
        Departments deps = new Departments();
        List<String> input = List.of("k1/sk1", "k2");
        List<Departments.Org> expect = List.of(
                new Departments.Org(List.of("k1")),
                new Departments.Org(List.of("k1", "sk1")),
                new Departments.Org(List.of("k2"))
        );
        List<Departments.Org> result = deps.sortAsc(deps.convert(input));
        assertThat(result, is(expect));
    }

    /**
     * Тест сортировки подразделений в нисходящем порядке.
     */
    @Test
    public void whenDesc() {
        Departments deps = new Departments();
        List<String> input = List.of("k1/sk1", "k2");
        List<Departments.Org> expect = List.of(
                new Departments.Org(List.of("k2")),
                new Departments.Org(List.of("k1")),
                new Departments.Org(List.of("k1", "sk1"))
        );
        List<Departments.Org> result = deps.sortDesc(deps.convert(input));
        assertThat(result, is(expect));
    }
}