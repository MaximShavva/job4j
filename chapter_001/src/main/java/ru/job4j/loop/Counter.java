package ru.job4j.loop;

/**
 * Класс для подсчёта суммы всех чётных чисел в заданном диапазоне.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 19.03.2019г.
 */
public class Counter {

    /**
     * Метод возвращает наибольшее из 3 переданных ему чисел.
     *
     * @param start начало диапазона.
     * @param finish конец диапазона.
     * @return сумма.
     */
    public int add(int start, int finish) {
        int sum = 0;
        int s, f;
        if (start < finish) {
            s = start;
            f = finish;
        } else {
            s = finish;
            f = start;
        }
        for (int i = s; i <= f; i++) {
            if (i % 2 == 0) sum += i;
        }
        return sum;
    }
}
