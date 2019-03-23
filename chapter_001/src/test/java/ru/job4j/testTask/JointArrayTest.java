package ru.job4j.testTask;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирует метод arraysJoining класа JointArray.
 *
 * @author Шавва Максим (masyam@mail.ru)
 * @version 1
 * @since 24.03.2019
 */
public class JointArrayTest {

    /**
     * тест возрастающих массивов, 1 короче.
     */
    @Test
    public void whenFirstShorterThenJointArray() {
        JointArray composer = new JointArray();
        int[] arrA = {1, 3, 4, 6};
        int[] arrB = {1, 2, 3, 5, 7};
        int[] result = {1, 1, 2, 3, 3, 4, 5, 6, 7};
        int[] actual = composer.arraysJoining(arrA, arrB);
        assertThat(actual, is(result));
    }

    /**
     * тест возрастающих массивов, 2 короче.
     */
    @Test
    public void whenFirstLongerThenJointArray() {
        JointArray composer = new JointArray();
        int[] arrA = {1, 2, 3, 5, 7};
        int[] arrB = {1, 3, 4, 6};
        int[] result = {1, 1, 2, 3, 3, 4, 5, 6, 7};
        int[] actual = composer.arraysJoining(arrA, arrB);
        assertThat(actual, is(result));
    }

    /**
     * тест убывающих массивов.
     */
    @Test
    public void whenArraysDecreasingThenJointArray() {
        JointArray composer = new JointArray();
        int[] arrA = {4, 4, 3, 1};
        int[] arrB = {6, 3, 1, 1, 0};
        int[] result = {6, 4, 4, 3, 3, 1, 1, 1, 0};
        int[] actual = composer.arraysJoining(arrA, arrB);
        assertThat(actual, is(result));
    }

    /**
     * тест массивов c одним элементом.
     */
    @Test
    public void whenArrays1ItemThenJointArray() {
        JointArray composer = new JointArray();
        int[] arrA = {4};
        int[] arrB = {6};
        int[] result = {4, 6};
        int[] actual = composer.arraysJoining(arrA, arrB);
        assertThat(actual, is(result));
    }

    /**
     * тест, когда один из массивов содержит одинаковые элементы.
     * а второй убыват.
     */
    @Test
    public void whenArraysSameItemsUpThenJointArray() {
        JointArray composer = new JointArray();
        int[] arrA = {2, 2, 2, 2};
        int[] arrB = {6, 3, 1, 1, 0};
        int[] result = {6, 3, 2, 2, 2, 2, 1, 1, 0};
        int[] actual = composer.arraysJoining(arrA, arrB);
        assertThat(actual, is(result));
    }

    /**
     * тест, когда один из массивов содержит одинаковые элементы.
     * а второй возрастает.
     */
    @Test
    public void whenArraysSameItemsDownThenJointArray() {
        JointArray composer = new JointArray();
        int[] arrB = {2, 2, 2, 2};
        int[] arrA = {0, 1, 1, 3, 6};
        int[] result = {0, 1, 1, 2, 2, 2, 2, 3, 6};
        int[] actual = composer.arraysJoining(arrA, arrB);
        assertThat(actual, is(result));
    }

    /**
     * тест, когда один из массивов не отсортирован.
     */
    @Test
    public void whenFirstUnsortedThenJointArray() {
        JointArray composer = new JointArray();
        int[] arrB = {2, 2, 2, 2};
        int[] arrA = {0, 1, 7, 3, 6};
        int[] result = {};
        int[] actual = composer.arraysJoining(arrA, arrB);
        assertThat(actual, is(result));
    }

    /**
     * тест, когда один из массивов не отсортирован.
     */
    @Test
    public void whenSecondUnsortedThenJointArray() {
        JointArray composer = new JointArray();
        int[] arrB = {2, 2, 3, 2};
        int[] arrA = {0, 1, 1, 3, 6};
        int[] result = {};
        int[] actual = composer.arraysJoining(arrA, arrB);
        assertThat(actual, is(result));
    }

}
