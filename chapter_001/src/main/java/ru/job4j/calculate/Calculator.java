package ru.job4j.calculate;

/**
 * Класс Calculator - первая программа "Hello World"
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 18.03.2019г.
 */
public class Calculator {

    /**
     * Метод складывает 2 значения с плавающей точкой и возвращает результат.
     * @param first Первое слогаемое.
     * @param second Второе слогаемое.
     * @return Результат сложения.
     */
    public double add(double first, double second) {
        return first + second;
    }

    /**
     * Метод вычитает 2 значения с плавающей точкой и возвращает результат.
     * @param first Уменьшаемое.
     * @param second Вычитаемое.
     * @return Результат вычитания.
     */
    public double subtract(double first, double second) {
        return first - second;
    }

    /**
     * Метод перемножает 2 значения с плавающей точкой и возвращает результат.
     * @param first Умножаемое.
     * @param second Множитель.
     * @return Результат умножения.
     */
    public double multiple(double first, double second) {
        return first * second;
    }

    /**
     * Метод делит 1-й параметр на 2-й и возвращает результат.
     * @param first Делимое.
     * @param second Делитель.
     * @return Частное.
     */
    public double div(double first, double second) {
        if (second != 0) {
            return first / second;
        } else {
            return Double.MAX_VALUE;
        }
    }
}
