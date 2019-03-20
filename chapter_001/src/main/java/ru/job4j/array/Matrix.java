package ru.job4j.array;

/**
 * Двумерный массив - таблица умножения.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 20.03.2019г.
 */
public class Matrix {

    /**
     * @param size величина двумерного массива.
     * @return массив - маблица умножения.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i != size; i++) {
            for (int j = 0; j != size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}