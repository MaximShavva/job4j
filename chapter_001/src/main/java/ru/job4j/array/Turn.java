package ru.job4j.array;

/**
 * Выполняет перестановку элементов массива для получения обратной последовательности.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 20.03.2019г.
 */
public class Turn {

    /**
     * @param array массив, который переворачивается в методе.
     * @return полученный в результате переворота массив.
     */
    public int[] back(int[] array) {
        int temp;
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
}
