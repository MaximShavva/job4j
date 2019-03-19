package ru.job4j.condition;

/**
 * Нахождение максимального из двух чисел.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 19.03.2019г.
 */
public class Max {

    /**
     * Нахождение максимального из двух чисел.
     *
     * @param first первое число.
     * @param second второе число.
     * @return результат.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
