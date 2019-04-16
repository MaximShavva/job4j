package ru.job4j.testtask.varc;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирует метод joinArrays класа Fusion.
 *
 * @author Шавва Максим (masyam@mail.ru)
 * @version 3
 * @since 27.03.2019
 */
public class FusionTest {

    /**
     * тест возрастающих массивов, 1 короче.
     */
    @Test
    public void whenFirstShorterThenJointArray() {
        Fusion composer = new Fusion();
        int[] a = {1, 3, 4, 6};
        int[] b = {1, 2, 3, 8, 9};
        int[] result = {1, 1, 2, 3, 3, 4, 6, 8, 9};
        int[] actual = composer.joinArrays(a, b);
        assertThat(actual, is(result));
    }

    /**
     * тест возрастающих массивов, 2 короче.
     */
    @Test
    public void whenFirstLongerThenJointArray() {
        Fusion composer = new Fusion();
        int[] a = {1, 2, 3, 5, 7};
        int[] b = {1, 3, 4};
        int[] result = {1, 1, 2, 3, 3, 4, 5, 7};
        int[] actual = composer.joinArrays(a, b);
        assertThat(actual, is(result));
    }

    /**
     * тест массивов c одним элементом.
     */
    @Test
    public void whenArrays1ItemThenJointArray() {
        Fusion composer = new Fusion();
        int[] a = {4};
        int[] b = {6};
        int[] result = {4, 6};
        int[] actual = composer.joinArrays(a, b);
        assertThat(actual, is(result));
    }

    /**
     * тест c пустым массивом.
     */
    @Test
    public void whenHasBlankArrayThenJointArray() {
        Fusion composer = new Fusion();
        int[] a = {4, 6};
        int[] b = {};
        int[] result = {4, 6};
        int[] actual = composer.joinArrays(a, b);
        assertThat(actual, is(result));
    }
}