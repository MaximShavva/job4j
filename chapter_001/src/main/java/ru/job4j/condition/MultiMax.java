package ru.job4j.condition;

/**
 * Класс для нахождения максимального из 3-х чисел.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 19.03.2019г.
 */
public class MultiMax {
    /**
     * Метод возвращает наибольшее из 3 переданных ему чисел.
     *
     * @param first первое число.
     * @param second второе число.
     * @param third третье число.
     * @return максимальное из 3х.
     */
    public int max(int first, int second, int third) {
        int result = first > second ? first : second;
        return result > third ? result : third;
    }
}
