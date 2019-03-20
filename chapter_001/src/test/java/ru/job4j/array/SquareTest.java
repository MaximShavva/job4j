package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс тестирует методы класа Square
 *
 * @author Шавва Максим (masyam@mail.ru)
 * @version 1
 * @since 20.03.2019
 */
public class SquareTest {
    /**
     * Тестируем Square.calculate() длиной массива 3.
     * */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(rst, is(expect));
    }

    /**
     * Тестируем Square.calculate() длиной массива 4.
     * */
    @Test
    public void whenBound4Then14916() {
        int bound = 4;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = {1, 4, 9, 16};
        assertThat(rst, is(expect));
    }

    /**
     * Тестируем Square.calculate() с пустым массивом.
     * */
    @Test
    public void whenBound0ThenZero() {
        int bound = 0;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[0];
        assertThat(rst, is(expect));
    }

}
