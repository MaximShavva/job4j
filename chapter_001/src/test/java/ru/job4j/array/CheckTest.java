package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса Check.
 *
 * @author Шавва Максим (masyam@mail.ru).
 * @version 1.
 * @since 20.03.2019.
 */
public class CheckTest {

    /**
     * Тестируем метод Check.mono() для всех true
     * */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Тестируем метод Check.mono() для всех false
     * */
    @Test
    public void whenDataMonoByFalseThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Тестируем метод Check.mono() для разных элементов
     * */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[]{true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Тестируем метод Check.mono() для одного элемента
     * */
    @Test
    public void whenDataHasOneElementThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[]{false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}