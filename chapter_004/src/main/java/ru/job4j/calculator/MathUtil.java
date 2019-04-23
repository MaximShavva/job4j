package ru.job4j.calculator;

/**
 * В этом классе были реслизованы инструментальные методы.
 * Мы хотим использовать их в нашем коде.
 * Для этого будем использовать ссылки на методы.
 */
public class MathUtil {
    public static double add(int left, int second) {
        return left + second;
    }

    public static double div(int left, int second) {
        return left / (double) second;
    }
}