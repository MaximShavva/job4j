package ru.job4j.testTask.varb;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирует метод joinArrays класа Merge.
 *
 * @author Шавва Максим (masyam@mail.ru)
 * @version 2
 * @since 25.03.2019
 */
public class MergeTest {

    /**
     * тест возрастающих массивов, 1 короче.
     */
    @Test
    public void whenFirstShorterThenJointArray() {
        Merge composer = new Merge();
        int[] arrA = {1, 3, 4, 6};
        int[] arrB = {1, 2, 3, 8, 9};
        int[] result = {1, 1, 2, 3, 3, 4, 6, 8, 9};
        int[] actual = composer.joinArrays(arrA, arrB);
        assertThat(actual, is(result));
    }

    /**
     * тест возрастающих массивов, 2 короче.
     */
    @Test
    public void whenFirstLongerThenJointArray() {
        Merge composer = new Merge();
        int[] arrA = {1, 2, 3, 5, 7};
        int[] arrB = {1, 3, 4};
        int[] result = {1, 1, 2, 3, 3, 4, 5, 7};
        int[] actual = composer.joinArrays(arrA, arrB);
        assertThat(actual, is(result));
    }

    /**
     * тест массивов c одним элементом.
     */
    @Test
    public void whenArrays1ItemThenJointArray() {
        Merge composer = new Merge();
        int[] arrA = {4};
        int[] arrB = {6};
        int[] result = {4, 6};
        int[] actual = composer.joinArrays(arrA, arrB);
        assertThat(actual, is(result));
    }

    /**
     * тест c пустым массивом.
     */
    @Test
    public void whenHasBlankArrayThenJointArray() {
        Merge composer = new Merge();
        int[] arrA = {4, 6};
        int[] arrB = {};
        int[] result = {4, 6};
        int[] actual = composer.joinArrays(arrA, arrB);
        assertThat(actual, is(result));
    }
}
