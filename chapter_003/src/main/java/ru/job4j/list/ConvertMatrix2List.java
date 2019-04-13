package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс содержит метод по преобразованию двумерного
 * массива в список ArrayList.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 13.04.2019г.
 */
public class ConvertMatrix2List {
    /**
     * @param array входной массив.
     * @return готовый список.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] ints : array) {
            for (int item : ints) {
                list.add(item);
            }
        }
        return list;
    }
}
