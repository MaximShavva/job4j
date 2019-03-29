package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестируем класс Square.
 *
 * @author Шавва Максим (masyam@mail.ru)
 * @version 1
 * @since 29.03.2019г.
 */
public class SquareTest {

    /**
     * Тест метода draw/
     */
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append(System.lineSeparator())
                                .append("+  +")
                                .append(System.lineSeparator())
                                .append("+  +")
                                .append(System.lineSeparator())
                                .append("++++")
                                .toString()
                )
        );
    }
}