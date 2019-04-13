package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования класса UserConvert.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 13.04.2019г.
 */
public class UserConvertTest {
    /**
     * Тестируем метод process()
     */
    @Test
    public void whenListThenMap() {
        UserConvert convert = new UserConvert();
        List<User> list = new ArrayList<>(Arrays.asList(
                new User(17, "Ivan Ivanov", "Moscow"),
                new User(26, "Klim Sidorov", "Urupinsk")));
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(17, list.get(0));
        expect.put(26, list.get(1));
        assertThat(convert.process(list), is(expect));
    }
}