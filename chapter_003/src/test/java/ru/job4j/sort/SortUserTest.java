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
        List<User> list = new ArrayList<>(Arrays.asList(
                new User("Anton", 48),
                new User("Vasily", 17),
                new User("Petr", 36)
                ));
        assertThat(arrange.sort(list).iterator().next().getName(), is("Vasily"));
    }

    /**
     * Тест метода SortUser.sortNameLength.
     */
    @Test
    public void whenListSortByLengthThen() {
        SortUser arrange = new SortUser();
        List<User> list = new ArrayList<>(Arrays.asList(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)
        ));
        List<String> result = new ArrayList<>();
        arrange.sortNameLength(list).forEach(user -> result.add(user.getName()));
        assertThat(result, is(
                new ArrayList<>(Arrays.asList("Иван", "Иван", "Сергей", "Сергей"))));
    }

    /**
     * Тест метода SortUser.sortByAllFields.
     */
    @Test
    public void whenListSortByAllFieldsThen() {
        SortUser arrange = new SortUser();
        List<User> list = new ArrayList<>(Arrays.asList(
                new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25)
        ));
        StringBuilder result = new StringBuilder();
        arrange.sortByAllFields(list).forEach(user -> {
            result.append(user.getName());
            result.append(" ");
            result.append(user.getAge());
            result.append(" / ");
        });
        assertThat(result.toString(), is("Иван 25 / Иван 30 / Сергей 20 / Сергей 25 / "));
    }
}