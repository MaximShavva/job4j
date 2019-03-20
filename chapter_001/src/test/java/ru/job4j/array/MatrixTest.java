package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса Matrix.
 *
 * @author Шавва Максим (masyam@mail.ru).
 * @version 1.
 * @since 20.03.2019.
 */
public class MatrixTest {

    /**
     * Тестируем Matrix.multiple()
     */
    @Test
    public void when2on2() {
        Matrix matrix = new Matrix();
        int[][] table = matrix.multiple(2);
        int[][] expect = {
                {1, 2},
                {2, 4}
        };
        assertThat(table, is(expect));
    }
}