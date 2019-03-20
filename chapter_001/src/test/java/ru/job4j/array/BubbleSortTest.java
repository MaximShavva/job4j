package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса BubbleSort.
 *
 * @author Шавва Максим (masyam@mail.ru).
 * @version 1.
 * @since 20.03.2019.
 */
public class BubbleSortTest {

    /**
     * Тестируем сортировку 10 элементов массива.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubble = new BubbleSort();
        int[] input = {8, 1, 5, 4, 2, 3, 1, 7, 5, 0};
        int[] expect = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        int[] result = bubble.sort(input);
        assertThat(result, is(expect));
    }

    /**
     * Тестируем сортировку 2 элементов массива.
     */
    @Test
    public void whenSortArrayWithTwoElementsThenSortedArray() {
        BubbleSort bubble = new BubbleSort();
        int[] input = {5, 1};
        int[] expect = {1, 5};
        int[] result = bubble.sort(input);
        assertThat(result, is(expect));
    }

    /**
     * Тестируем сортировку 1 элемента массива.
     */
    @Test
    public void whenSortArrayWithOneElementsThenSortedArray() {
        BubbleSort bubble = new BubbleSort();
        int[] input = {5};
        int[] expect = {5};
        int[] result = bubble.sort(input);
        assertThat(result, is(expect));
    }
}