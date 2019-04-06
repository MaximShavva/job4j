package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.*;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.PawnWhite;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса Logic.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 8.04.2019г.
 */
public class LogicTest {

    /**
     * Когда ход фигура не найдена.
     */
    @Test
    public void whenFigureNotFoundThen() {
        Logic logic = new Logic();
        String result = "";
        try {
            logic.move(Cell.D4, Cell.E3);
        } catch (ImpossibleMoveException | OccupiedWayException | FigureNotFoundException exc) {
            result = exc.getMessage();
        }
        assertThat(result, is("Фигура не найдена"));
    }

    /**
     * Когда ход фигуры задан неверно.
     */
    @Test
    public void whenIllegalmoveThen() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.D4));
        String result = "";
        try {
            logic.move(Cell.D4, Cell.A4);
        } catch (ImpossibleMoveException | OccupiedWayException | FigureNotFoundException exc) {
            result = exc.getMessage();
        }
        assertThat(result, is("Такой ход недопустим"));
    }

    /**
     * Когда ход фигуры преграждён другой ыигурой.
     */
    @Test
    public void whenOccupiedWayThen() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.D4));
        logic.add(new PawnWhite(Cell.F2));
        String result = "";
        try {
            logic.move(Cell.D4, Cell.G1);
        } catch (ImpossibleMoveException | OccupiedWayException | FigureNotFoundException exc) {
            result = exc.getMessage();
        }
        assertThat(result, is("Путь движения фигуры занят"));
    }
}