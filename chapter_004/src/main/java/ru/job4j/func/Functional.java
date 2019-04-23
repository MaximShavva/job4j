package ru.job4j.func;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Класс содержит набор функций аргумента double, которые можно
 * подставлять в метод diapason, меняя его функциональность.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 24.04.2019г.
 */
public class Functional {

    /**
     * @param start Начало диапазона для расчёта лямбда-функции.
     * @param end Конец диапазона для расчёта лямбда-функции.
     * @param func Instance стандартного функционального интерфейса.
     * @return Список значений лямбда-функции в диапазоне.
     */
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i != end; i++) {
            result.add(func.apply((double) i));
        }
        return result;
    }

    /**
     * Содержит набор методов для подстановки в лямбда.
     */
    public static class FunctionSet {
        public static Double liner(Double x) {
            return 2 * x + 1;
        }

        public static Double square(Double x) {
            return x * (x - 5);
        }

        public static Double logarithmic(Double x) {
            return Math.log10(x) + Math.log(x);
        }
    }
}