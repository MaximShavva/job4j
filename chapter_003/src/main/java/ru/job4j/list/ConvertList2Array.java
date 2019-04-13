package ru.job4j.list;

import java.util.List;

/**
 * Класс содержит метод по преобразованию списка
 * в двумерный массив с заданным количеством строк.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 12.04.2019г.
 */
public class ConvertList2Array {
    /**
     * @param list список для преобразования в массив.
     * @param rows количество строк, которое должно быть в массиве.
     * @return двумерный массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil(list.size() / (double) rows);
        int[][] array = new int[rows][cells];
        int i = 0, j = 0;
        for (Integer item : list) {
            array[j][i++] = item;
            if (i == cells) {
                j++;
                i = 0;
            }
        }
        return array;
    }
}
