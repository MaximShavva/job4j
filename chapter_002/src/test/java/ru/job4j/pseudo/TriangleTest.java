package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестируем класс Triangle.
 *
 * @author Шавва Максим (masyam@mail.ru)
 * @version 1
 * @since 29.03.2019г.
 */
public class TriangleTest {

    /**
     * Тест метода draw/
     */
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("   +   ")
                                .append(System.lineSeparator())
                                .append("  + +  ")
                                .append(System.lineSeparator())
                                .append(" +   + ")
                                .append(System.lineSeparator())
                                .append("+++++++")
                                .toString()
                )
        );
    }
}