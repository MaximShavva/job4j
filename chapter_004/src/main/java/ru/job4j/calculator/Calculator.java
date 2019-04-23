package ru.job4j.calculator;

import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * Класс содержит метод по выводу таблицы умножения.
 * <p>
 * Нужный ункционал задаётся Функциональным интерфейсом BiFunction,
 * функция accept которого реализуется л-выражением.
 * <p>
 * Вывод таблицы на экран производится через метод интерфейса
 * Consumer, метод media которого реализуется в л-выражении.
 * <p>
 * Показано, как с помошью ссылик на метод вставить тело этого
 * метода в лямбда-выражение.
 */
public class Calculator {

    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        //Лямбда.
        calculator.multiple(1, 5, 2,
                (value, index) -> value * (double) index,
                (doubl) -> System.out.print(" / " + doubl)
        );
        //Ссылка на метод.
        calculator.multiple(1, 5, 20,
                MathUtil::div,
                (doubl) -> System.out.print(" / " + doubl)
        );
    }
}