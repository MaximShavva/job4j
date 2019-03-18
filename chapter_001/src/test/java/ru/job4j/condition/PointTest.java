package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса Point.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 18.03.2019г.
 */
public class PointTest {

    /**
     * Тестируем метод distance.
     */
    @Test
    public void whenZeroAndTenThenTen() {
        Point point = new Point();
        double result = point.distance(0, 0, 0, 10);
        assertThat(result, is(10D));
    }
}