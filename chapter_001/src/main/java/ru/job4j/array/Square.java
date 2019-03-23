package ru.job4j.array;

/**
 * Класс для возведения в квадрат чисел от 1 до n.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 20.03.2019г.
 */
public class Square {
    /**
     *Метод возводит в квадрат числа, возвращает их в виде массива.
     *
     * @param bound максимальное число, которое возводится в квадрат.
     * @return массив из bound элементов.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i != rst.length; i++) {
            rst[i] = (i + 1) * (i + 1);
        }
        return rst;
    }
}