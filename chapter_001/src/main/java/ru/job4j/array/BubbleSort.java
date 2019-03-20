package ru.job4j.array;

/**
 * Сортировка массива методом пузырька.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 20.03.2019г.
 */
public class BubbleSort {

    /**
     * @param array Массив, который нужно отсортировать.
     * @return отсортированный массив
     */
    public int[] sort(int[] array) {
        int temp;
        int passCount = array.length - 1;
        for (int i = 0; i < passCount; i++) {
            for (int j = 0; j < passCount - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}