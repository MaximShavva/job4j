package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса ArrayChar.
 *
 * @author Шавва Максим (masyam@mail.ru).
 * @version 1.
 * @since 20.03.2019.
 */
public class ArrayCharTest {

    /**
     * Тестируем метод ArrayChar.startWith() когда префикс входит в строку.
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }

    /**
     * Тестируем метод ArrayChar.startWith() когда префикс не входит в строку.
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }

    /**
     * Тестируем метод ArrayChar.startWith() когда префикс длиннее строки.
     */
    @Test
    public void whenPrefixToLongThenFalse() {
        ArrayChar word = new ArrayChar("Hell");
        boolean result = word.startWith("Hello");
        assertThat(result, is(false));
    }
}