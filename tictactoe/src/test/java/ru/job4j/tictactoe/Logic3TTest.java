package ru.job4j.tictactoe;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования Logic3T.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 29.04.2019г.
 */
public class Logic3TTest {

    /**
     * Тестируем .isWinnerO() для комбинации:
     * Х _ _
     * _ Х _
     * _ _ Х
     */
    @Test
    public void whenHasXWinner() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
        };
        var logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    /**
     * Тестируем .isWinnerO() для комбинации:
     * Х _ _
     * _ _ _
     * _ _ _
     */
    @Test
    public void whenNotFill() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        var logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(false));
        assertThat(logic.isWinnerO(), is(false));
    }

    /**
     * Тестируем .isWinnerO() для комбинации:
     * Х Х Х
     * _ _ _
     * _ _ _
     */
    @Test
    public void whenHasXHorizontal1Winner() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(true, false), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()}
        };
        var logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    /**
     * Тестируем .isWinnerO() для комбинации:
     * _ _ _
     * Х Х Х
     * _ _ _
     */
    @Test
    public void whenHasXHorizontal2Winner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true, false), new Figure3T(true, false), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(), new Figure3T()},
        };
        var logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    /**
     * Тестируем .isWinnerO() для комбинации:
     * _ _ _
     * _ _ _
     * Х Х Х
     */
    @Test
    public void whenHasXHorizontal3Winner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T()},
                {new Figure3T(true, false), new Figure3T(true, false), new Figure3T(true, false)}
        };
        var logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    /**
     * Тестируем .isWinnerO() для комбинации:
     *  Х _ _
     *  Х _ _
     *  Х _ _
     */
    @Test
    public void whenHasXVertical1Winner() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T() , new Figure3T()},
                {new Figure3T(true, false), new Figure3T() , new Figure3T()},
                {new Figure3T(true, false), new Figure3T() , new Figure3T()}
        };
        var logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    /**
     * Тестируем .isWinnerO() для комбинации:
     * _ Х _
     * _ Х _
     * _ Х _
     */
    @Test
    public void whenHasXVertical2Winner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()}
        };
        var logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    /**
     * Тестируем .isWinnerO() для комбинации:
     * _ _ Х
     * _ _ Х
     * _ _ Х
     */
    @Test
    public void whenHasXVertical3Winner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)}
        };
        var logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    /**
     * Тестируем .isWinnerO() для комбинации:
     * _ _ Х
     * _ Х _
     * Х _ _
     */
    @Test
    public void whenHasXBackDiagonalWinner() {
        Figure3T[][] table = {
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
        };
        var logic = new Logic3T(table);
        assertThat(logic.isWinnerX(), is(true));
    }

    /**
     * Тестируем .isWinnerO() для комбинации:
     * О _ _
     * О О _
     * О _ О
     */
    @Test
    public void whenHasOWinner() {
        Figure3T[][] table = {
                {new Figure3T(false, true), new Figure3T(), new Figure3T()},
                {new Figure3T(false, true), new Figure3T(false, true), new Figure3T()},
                {new Figure3T(false, true), new Figure3T(), new Figure3T(false, true)},
        };
        var logic = new Logic3T(table);
        assertThat(logic.isWinnerO(), is(true));
    }

    /**
     * Тестируем метод .hasGap()
     */
    @Test
    public void whenHasGap() {
        Figure3T[][] table = {
                {new Figure3T(true, false), new Figure3T(), new Figure3T()},
                {new Figure3T(), new Figure3T(true, false), new Figure3T()},
                {new Figure3T(), new Figure3T(), new Figure3T(true, false)},
        };
        var logic = new Logic3T(table);
        assertThat(logic.hasGap(), is(true));
    }
}