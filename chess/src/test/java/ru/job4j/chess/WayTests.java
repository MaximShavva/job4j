package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImpossibleMoveException;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;
import ru.job4j.chess.firuges.black.QueenBlack;
import ru.job4j.chess.firuges.white.KingWhite;
import ru.job4j.chess.firuges.white.KnightWhite;
import ru.job4j.chess.firuges.white.PawnWhite;
import ru.job4j.chess.firuges.white.RookWhite;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест метода way() для фигур шахматной доски.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 8.04.2019г.
 */
public class WayTests {
    /**
     * Чёрная пешка ходит c D7 На D6.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenBlackPawnD7ThenD6() throws ImpossibleMoveException {
        Figure pawnBlack = new PawnBlack(Cell.D7);
        Cell[] moves = {Cell.D5, Cell.D6, Cell.D8,
                Cell.E6, Cell.E7, Cell.E8,
                Cell.C8, Cell.C7, Cell.C6};
        Cell[] result = new Cell[9];
        for (int i = 0; i < moves.length; i++) {
            Cell[] way = pawnBlack.way(Cell.D7, moves[i]);
            if (way.length > 0) {
                result[i] = way[0];
            }
        }
        assertThat(result, is(new Cell[]{null, Cell.D6, null, null, null, null, null, null, null}));
    }

    /**
     * Белая пешка ходит c E2 На E3.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenWhitePawnE2ThenE3() throws ImpossibleMoveException {
        Figure pawnWhite = new PawnWhite(Cell.E2);
        Cell[] moves = {Cell.D1, Cell.D2, Cell.D3,
                Cell.E1, Cell.E3, Cell.E4,
                Cell.F1, Cell.F2, Cell.F3};
        Cell[] result = new Cell[9];
        for (int i = 0; i < moves.length; i++) {
            Cell[] way = pawnWhite.way(Cell.E2, moves[i]);
            if (way.length > 0) {
                result[i] = way[0];
            }
        }
        assertThat(result, is(new Cell[]{null, null, null, null, Cell.E3, null, null, null, null}));
    }

    /**
     * Конь ходит c D4.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenKnightMovesThen() throws ImpossibleMoveException {
        Figure knight = new KnightWhite(Cell.D4);
        Cell[] moves = {Cell.D2, Cell.C2, Cell.B3,
                Cell.B4, Cell.B5, Cell.C6,
                Cell.D6, Cell.E6, Cell.F5,
                Cell.F4, Cell.F3, Cell.E2};
        Cell[] result = new Cell[12];
        for (int i = 0; i < moves.length; i++) {
            Cell[] way = knight.way(Cell.D4, moves[i]);
            if (way.length > 0) {
                result[i] = way[0];
            }
        }
        assertThat(result, is(new Cell[]{
                null, Cell.C2, Cell.B3,
                null, Cell.B5, Cell.C6,
                null, Cell.E6, Cell.F5,
                null, Cell.F3, Cell.E2}));
    }

    /**
     * Король ходит c D4.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenKingMovesThen() throws ImpossibleMoveException {
        Figure king = new KingWhite(Cell.D4);
        Cell[] moves = {Cell.C3, Cell.C4, Cell.C5,
                Cell.D3, Cell.D5, Cell.E3,
                Cell.E4, Cell.E5, Cell.B4,
                Cell.D6, Cell.D2, Cell.F4};
        Cell[] result = new Cell[12];
        for (int i = 0; i < moves.length; i++) {
            Cell[] way = king.way(Cell.D4, moves[i]);
            if (way.length > 0) {
                result[i] = way[0];
            }
        }
        assertThat(result, is(new Cell[]{
                Cell.C3, Cell.C4, Cell.C5, Cell.D3,
                Cell.D5, Cell.E3, Cell.E4, Cell.E5,
                null, null, null, null}));
    }

    /**
     * Ладья ходит с D4.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenRookMovesThen() throws ImpossibleMoveException {
        Figure rook = new RookWhite(Cell.D4);
        assertThat(rook.way(Cell.D4, Cell.H4), is(new Cell[]{Cell.E4, Cell.F4, Cell.G4, Cell.H4}));
        assertThat(rook.way(Cell.D4, Cell.D8), is(new Cell[]{Cell.D5, Cell.D6, Cell.D7, Cell.D8}));
        assertThat(rook.way(Cell.D4, Cell.A4), is(new Cell[]{Cell.C4, Cell.B4, Cell.A4}));
        assertThat(rook.way(Cell.D4, Cell.D1), is(new Cell[]{Cell.D3, Cell.D2, Cell.D1}));
        assertThat(rook.way(Cell.D4, Cell.E5).length, is(0));
        assertThat(rook.way(Cell.D4, Cell.C5).length, is(0));
        assertThat(rook.way(Cell.D4, Cell.E3).length, is(0));
        assertThat(rook.way(Cell.D4, Cell.C3).length, is(0));
    }

    /**
     * Слон ходит с D4.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenBishopMovesThen() throws ImpossibleMoveException {
        Figure bishop = new BishopBlack(Cell.D4);
        assertThat(bishop.way(Cell.D4, Cell.A1), is(new Cell[]{Cell.C3, Cell.B2, Cell.A1}));
        assertThat(bishop.way(Cell.D4, Cell.H8), is(new Cell[]{Cell.E5, Cell.F6, Cell.G7, Cell.H8}));
        assertThat(bishop.way(Cell.D4, Cell.A7), is(new Cell[]{Cell.C5, Cell.B6, Cell.A7}));
        assertThat(bishop.way(Cell.D4, Cell.G1), is(new Cell[]{Cell.E3, Cell.F2, Cell.G1}));
        assertThat(bishop.way(Cell.D4, Cell.D5).length, is(0));
        assertThat(bishop.way(Cell.D4, Cell.C4).length, is(0));
        assertThat(bishop.way(Cell.D4, Cell.D3).length, is(0));
        assertThat(bishop.way(Cell.D4, Cell.E4).length, is(0));
    }

    /**
     * Ферзь ходит с D4.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenQueenMovesThen() throws ImpossibleMoveException {
        Figure queen = new QueenBlack(Cell.D4);
        assertThat(queen.way(Cell.D4, Cell.A1), is(new Cell[]{Cell.C3, Cell.B2, Cell.A1}));
        assertThat(queen.way(Cell.D4, Cell.H8), is(new Cell[]{Cell.E5, Cell.F6, Cell.G7, Cell.H8}));
        assertThat(queen.way(Cell.D4, Cell.A7), is(new Cell[]{Cell.C5, Cell.B6, Cell.A7}));
        assertThat(queen.way(Cell.D4, Cell.G1), is(new Cell[]{Cell.E3, Cell.F2, Cell.G1}));
        assertThat(queen.way(Cell.D4, Cell.H4), is(new Cell[]{Cell.E4, Cell.F4, Cell.G4, Cell.H4}));
        assertThat(queen.way(Cell.D4, Cell.D8), is(new Cell[]{Cell.D5, Cell.D6, Cell.D7, Cell.D8}));
        assertThat(queen.way(Cell.D4, Cell.A4), is(new Cell[]{Cell.C4, Cell.B4, Cell.A4}));
        assertThat(queen.way(Cell.D4, Cell.D1), is(new Cell[]{Cell.D3, Cell.D2, Cell.D1}));
        assertThat(queen.way(Cell.D4, Cell.B5).length, is(0));
        assertThat(queen.way(Cell.D4, Cell.F5).length, is(0));
        assertThat(queen.way(Cell.D4, Cell.C2).length, is(0));
        assertThat(queen.way(Cell.D4, Cell.E2).length, is(0));
    }
}
