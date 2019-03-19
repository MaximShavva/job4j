package ru.job4j.loop;

/**
 * Класс для вычисления факториала.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 19.03.2019г.
 */
public class Factorial {

    /**
     * Метод возвращает наибольшее из 3 переданных ему чисел.
     *
     * @param n натуральное число.
     * @return факториал.
     */
    public int calc(int n) {
        int result = 1;
        if (n > 1) {
            for (int i = n; i != 1; i--) {
                result *= i;
            }
        }
        return result;
    }
}