package ru.job4j.array;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса MatrixCheck.
 *
 * @author Шавва Максим (masyam@mail.ru).
 * @version 1.
 * @since 20.03.2019.
 */
public class MatrixCheckTest {
    /**
     * Тест MatrixCheck.mono().
     * Случай, когда 2 диагонали пересекаются и они однородны.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Тест MatrixCheck.mono().
     * Случай, когда 2 диагонали пересекаются и они неоднородны.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Тест MatrixCheck..mono().
     * Случай, когда 2 диагонали не пересекаются и они разно-однородны.
     */
    @Test
    public void whenDataMonoNotIntersectedThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false},
                {false, true},
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}
