package ru.job4j.chess.firuges.way;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.FigureAbstract;
import ru.job4j.chess.firuges.ImpossibleMoveException;

/**
 * Расширяет класс FigureAbstract, переопределяя метод way() для фигуры Ферзь.
 *
 * @author Шавва Максим.
 * @version 2.1
 * @since 11.04.2019г.
 */
public abstract class QueenWay extends FigureAbstract {
    /**
     * @param position зазаём позицию ферзя на доске.
     */
    public QueenWay(Cell position) {
        super(position);
    }

    /**
     * Проверяет, что Ферзь может так двигаться.
     *
     * @param source клетка исходного положения.
     * @param dest   клетка конечного положения.
     * @return массив клеток, через которые двигается фигурка.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int vert = dest.y - source.y;
        int horiz = dest.x - source.x;
        if ((vert == 0 && horiz == 0)
                || (horiz != 0 && vert != 0 && (Math.abs(vert) != Math.abs(horiz)))) {
            throw new ImpossibleMoveException();
        }
        Cell[] steps = (vert == 0) ? new Cell[Math.abs(horiz)] : new Cell[Math.abs(vert)];
        for (int i = 1; i <= steps.length; i++) {
            steps[i - 1] = findBy(
                    (source.x + ((int) Math.signum(horiz) * i)),
                    (source.y + ((int) Math.signum(vert) * i))
            );
        }
        return steps;
    }
}