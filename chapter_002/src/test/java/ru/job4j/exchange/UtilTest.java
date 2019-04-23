package ru.job4j.exchange;

import org.junit.Test;

import java.util.NavigableSet;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестируем класс Util.
 *
 * @author Шавва Максим (masyam@mail.ru)
 * @version 1
 * @since 23.04.2019г.
 */
public class UtilTest {

    /**
     * Тест метода Util.sortCoin().
     */
    @Test
    public void whenMassiveThenSet() {
        NavigableSet<Integer> result = Util.sortCoin(new int[]{1, 3, 2});
        assertThat(result.toArray(), is(new int[]{3, 2, 1}));
    }

    /**
     * Тест метода Util.listUnion().
     */
    @Test
    public void when2ListsThenOneList() {
        assertThat(Util.listUnion(asList(5, 5), asList(3, 2)), is(asList(5, 5, 3, 2)));
    }
}
