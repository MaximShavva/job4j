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
}