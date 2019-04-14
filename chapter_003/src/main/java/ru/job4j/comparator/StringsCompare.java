package ru.job4j.comparator;

import java.util.Comparator;

/**
 * Класс - компаратор.
 * Сравнение строк в лексикографическом порядке.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 14.04.2019г.
 */
public class StringsCompare implements Comparator<String> {

    /**
     * @param left  первая строка.
     * @param right вторая строка.
     * @return результат лексикографического сравнения.
     */
    @Override
    public int compare(String left, String right) {
        char[] first = left.toCharArray();
        char[] second = right.toCharArray();
        int result = 0;
        for (int i = 0; i != Math.min(second.length, first.length); i++) {
            if (first[i] != second[i]) {
                result = Character.compare(first[i], second[i]);
                break;
            }
        }
        if (result == 0) result = Integer.compare(first.length, second.length);
        return result;
    }
}