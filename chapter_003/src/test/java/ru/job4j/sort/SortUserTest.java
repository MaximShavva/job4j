package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Класс для тестирования SortUser.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 14.04.2019г.
 */
public class SortUserTest {
    /**
     * Тест метода SortUser.sort.
     */
    @Test
    public void whenListThenTreeSet() {
        SortUser arrange = new SortUser();
        List<User> list = new ArrayList<>(List.of(
                new User("Anton", 48),
                new User("Vasily", 17),
                new User("Petr", 36)
        ));
        assertThat(arrange.sort(list), is(Set.of(
                new User("Vasily", 17),
                new User("Petr", 36),
                new User("Anton", 48)
        )));
    }

    /**
     * Тест метода SortUser.sortNameLength.
     */
    @Test
    public void whenListSortByLengthThen() {
        SortUser arrange = new SortUser();
        List<User> list = new ArrayList<>(List.of(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)
        ));
        assertThat(arrange.sortNameLength(list), is(List.of(
                new User("Иван", 30),
                new User("Иван", 25),
                new User("Сергей", 25),
                new User("Сергей", 20)
        )));
    }

    /**
     * Тест метода SortUser.sortByAllFields.
     */
    @Test
    public void whenListSortByAllFieldsThen() {
        SortUser arrange = new SortUser();
        List<User> list = new ArrayList<>(List.of(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)
        ));
        assertThat(arrange.sortByAllFields(list), is(List.of(
                new User("Иван", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Сергей", 25)
        )));
    }
}